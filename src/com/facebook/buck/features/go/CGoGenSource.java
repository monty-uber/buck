/*
 * Copyright 2016-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.features.go;

import com.facebook.buck.io.BuildCellRelativePath;
import com.facebook.buck.io.filesystem.ProjectFilesystem;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.BuildTargets;
import com.facebook.buck.rules.AbstractBuildRule;
import com.facebook.buck.rules.AddToRuleKey;
import com.facebook.buck.rules.BuildContext;
import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.BuildableContext;
import com.facebook.buck.rules.BuildableSupport;
import com.facebook.buck.rules.ExplicitBuildTargetSourcePath;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourcePathResolver;
import com.facebook.buck.rules.SourcePathRuleFinder;
import com.facebook.buck.rules.Tool;
import com.facebook.buck.step.Step;
import com.facebook.buck.step.fs.MakeCleanDirectoryStep;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.io.File;
import java.nio.file.Path;
import java.util.SortedSet;

public class CGoGenSource extends AbstractBuildRule {
  @AddToRuleKey private final ImmutableSet<SourcePath> cgoSrcs;
  @AddToRuleKey private final Tool cgo;
  @AddToRuleKey private final GoPlatform platform;
  @AddToRuleKey private final ImmutableList<String> cgoCompilerFlags;

  private final ImmutableSortedSet<BuildRule> buildDeps;
  private final Path genDir;
  private final ImmutableList<SourcePath> cFiles;
  private final ImmutableList<SourcePath> cgoFiles;
  private final ImmutableList<SourcePath> goFiles;

  public CGoGenSource(
      BuildTarget buildTarget,
      ProjectFilesystem projectFilesystem,
      SourcePathRuleFinder ruleFinder,
      SourcePathResolver pathResolver,
      ImmutableSet<SourcePath> cgoSrcs,
      Tool cgo,
      ImmutableList<String> cgoCompilerFlags,
      GoPlatform platform) {
    super(buildTarget, projectFilesystem);
    this.cgoSrcs = cgoSrcs;
    this.cgo = cgo;
    this.cgoCompilerFlags = cgoCompilerFlags;
    this.platform = platform;
    this.genDir = BuildTargets.getGenPath(projectFilesystem, buildTarget, "%s/gen/");

    ImmutableList.Builder<SourcePath> cBuilder = ImmutableList.builder();
    ImmutableList.Builder<SourcePath> cgoBuilder = ImmutableList.builder();
    ImmutableList.Builder<SourcePath> goBuilder = ImmutableList.builder();

    for (SourcePath srcPath : cgoSrcs) {
      String path =
          projectFilesystem
              .getPathForRelativePath(getBuildTarget().getBasePath())
              .relativize(pathResolver.getAbsolutePath(srcPath))
              .toString();
      String filename = path.substring(0, path.lastIndexOf('.')).replace(File.separatorChar, '_');

      // cgo generates 2 files for each Go sources, 1 .cgo1.go and 1 .cgo2.c
      goBuilder.add(
          ExplicitBuildTargetSourcePath.of(buildTarget, genDir.resolve(filename + ".cgo1.go")));
      cBuilder.add(
          ExplicitBuildTargetSourcePath.of(buildTarget, genDir.resolve(filename + ".cgo2.c")));
    }

    cBuilder.add(ExplicitBuildTargetSourcePath.of(buildTarget, genDir.resolve("_cgo_export.c")));
    cgoBuilder.add(ExplicitBuildTargetSourcePath.of(buildTarget, genDir.resolve("_cgo_main.c")));

    goBuilder.add(ExplicitBuildTargetSourcePath.of(buildTarget, genDir.resolve("_cgo_gotypes.go")));

    this.cFiles = cBuilder.build();
    this.cgoFiles = cgoBuilder.build();
    this.goFiles = goBuilder.build();

    this.buildDeps =
        ImmutableSortedSet.<BuildRule>naturalOrder()
            .addAll(BuildableSupport.getDepsCollection(cgo, ruleFinder))
            .addAll(ruleFinder.filterBuildRuleInputs(cgoSrcs))
            .build();
  }

  @Override
  public ImmutableList<Step> getBuildSteps(
      BuildContext context, BuildableContext buildableContext) {

    ImmutableList.Builder<Step> steps = ImmutableList.builder();
    steps.addAll(
        MakeCleanDirectoryStep.of(
            BuildCellRelativePath.fromCellRelativePath(
                context.getBuildCellRootPath(), getProjectFilesystem(), genDir)));
    steps.add(
        new CGoCompileStep(
            getBuildTarget(),
            getProjectFilesystem().getPathForRelativePath(getBuildTarget().getBasePath()),
            cgo.getEnvironment(context.getSourcePathResolver()),
            cgo.getCommandPrefix(context.getSourcePathResolver()),
            cgoCompilerFlags,
            cgoSrcs
                .stream()
                .map(context.getSourcePathResolver()::getAbsolutePath)
                .collect(ImmutableList.toImmutableList()),
            platform,
            getProjectFilesystem().getPathForRelativePath(genDir)));

    buildableContext.recordArtifact(genDir);
    return steps.build();
  }

  @Override
  public SortedSet<BuildRule> getBuildDeps() {
    return buildDeps;
  }

  @Override
  public SourcePath getSourcePathToOutput() {
    return ExplicitBuildTargetSourcePath.of(getBuildTarget(), genDir);
  }

  public ImmutableList<SourcePath> getCFiles() {
    return cFiles;
  }

  public ImmutableList<SourcePath> getCgoFiles() {
    return cgoFiles;
  }

  public ImmutableList<SourcePath> getGoFiles() {
    return goFiles;
  }

  public SourcePath getExportHeader() {
    return ExplicitBuildTargetSourcePath.of(getBuildTarget(), genDir.resolve("_cgo_export.h"));
  }
}
