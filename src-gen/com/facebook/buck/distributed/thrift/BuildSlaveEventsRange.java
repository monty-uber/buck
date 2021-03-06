/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)")
public class BuildSlaveEventsRange implements org.apache.thrift.TBase<BuildSlaveEventsRange, BuildSlaveEventsRange._Fields>, java.io.Serializable, Cloneable, Comparable<BuildSlaveEventsRange> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BuildSlaveEventsRange");

  private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField ERROR_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMessage", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField QUERY_FIELD_DESC = new org.apache.thrift.protocol.TField("query", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField EVENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("events", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BuildSlaveEventsRangeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BuildSlaveEventsRangeTupleSchemeFactory();

  public boolean success; // optional
  public java.lang.String errorMessage; // optional
  public BuildSlaveEventsQuery query; // optional
  public java.util.List<SequencedBuildSlaveEvent> events; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SUCCESS((short)1, "success"),
    ERROR_MESSAGE((short)2, "errorMessage"),
    QUERY((short)3, "query"),
    EVENTS((short)4, "events");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SUCCESS
          return SUCCESS;
        case 2: // ERROR_MESSAGE
          return ERROR_MESSAGE;
        case 3: // QUERY
          return QUERY;
        case 4: // EVENTS
          return EVENTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __SUCCESS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SUCCESS,_Fields.ERROR_MESSAGE,_Fields.QUERY,_Fields.EVENTS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.ERROR_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("errorMessage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QUERY, new org.apache.thrift.meta_data.FieldMetaData("query", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildSlaveEventsQuery.class)));
    tmpMap.put(_Fields.EVENTS, new org.apache.thrift.meta_data.FieldMetaData("events", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SequencedBuildSlaveEvent.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BuildSlaveEventsRange.class, metaDataMap);
  }

  public BuildSlaveEventsRange() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BuildSlaveEventsRange(BuildSlaveEventsRange other) {
    __isset_bitfield = other.__isset_bitfield;
    this.success = other.success;
    if (other.isSetErrorMessage()) {
      this.errorMessage = other.errorMessage;
    }
    if (other.isSetQuery()) {
      this.query = new BuildSlaveEventsQuery(other.query);
    }
    if (other.isSetEvents()) {
      java.util.List<SequencedBuildSlaveEvent> __this__events = new java.util.ArrayList<SequencedBuildSlaveEvent>(other.events.size());
      for (SequencedBuildSlaveEvent other_element : other.events) {
        __this__events.add(new SequencedBuildSlaveEvent(other_element));
      }
      this.events = __this__events;
    }
  }

  public BuildSlaveEventsRange deepCopy() {
    return new BuildSlaveEventsRange(this);
  }

  @Override
  public void clear() {
    setSuccessIsSet(false);
    this.success = false;
    this.errorMessage = null;
    this.query = null;
    this.events = null;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public BuildSlaveEventsRange setSuccess(boolean success) {
    this.success = success;
    setSuccessIsSet(true);
    return this;
  }

  public void unsetSuccess() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SUCCESS_ISSET_ID);
  }

  /** Returns true if field success is set (has been assigned a value) and false otherwise */
  public boolean isSetSuccess() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SUCCESS_ISSET_ID);
  }

  public void setSuccessIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SUCCESS_ISSET_ID, value);
  }

  public java.lang.String getErrorMessage() {
    return this.errorMessage;
  }

  public BuildSlaveEventsRange setErrorMessage(java.lang.String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public void unsetErrorMessage() {
    this.errorMessage = null;
  }

  /** Returns true if field errorMessage is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMessage() {
    return this.errorMessage != null;
  }

  public void setErrorMessageIsSet(boolean value) {
    if (!value) {
      this.errorMessage = null;
    }
  }

  public BuildSlaveEventsQuery getQuery() {
    return this.query;
  }

  public BuildSlaveEventsRange setQuery(BuildSlaveEventsQuery query) {
    this.query = query;
    return this;
  }

  public void unsetQuery() {
    this.query = null;
  }

  /** Returns true if field query is set (has been assigned a value) and false otherwise */
  public boolean isSetQuery() {
    return this.query != null;
  }

  public void setQueryIsSet(boolean value) {
    if (!value) {
      this.query = null;
    }
  }

  public int getEventsSize() {
    return (this.events == null) ? 0 : this.events.size();
  }

  public java.util.Iterator<SequencedBuildSlaveEvent> getEventsIterator() {
    return (this.events == null) ? null : this.events.iterator();
  }

  public void addToEvents(SequencedBuildSlaveEvent elem) {
    if (this.events == null) {
      this.events = new java.util.ArrayList<SequencedBuildSlaveEvent>();
    }
    this.events.add(elem);
  }

  public java.util.List<SequencedBuildSlaveEvent> getEvents() {
    return this.events;
  }

  public BuildSlaveEventsRange setEvents(java.util.List<SequencedBuildSlaveEvent> events) {
    this.events = events;
    return this;
  }

  public void unsetEvents() {
    this.events = null;
  }

  /** Returns true if field events is set (has been assigned a value) and false otherwise */
  public boolean isSetEvents() {
    return this.events != null;
  }

  public void setEventsIsSet(boolean value) {
    if (!value) {
      this.events = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case SUCCESS:
      if (value == null) {
        unsetSuccess();
      } else {
        setSuccess((java.lang.Boolean)value);
      }
      break;

    case ERROR_MESSAGE:
      if (value == null) {
        unsetErrorMessage();
      } else {
        setErrorMessage((java.lang.String)value);
      }
      break;

    case QUERY:
      if (value == null) {
        unsetQuery();
      } else {
        setQuery((BuildSlaveEventsQuery)value);
      }
      break;

    case EVENTS:
      if (value == null) {
        unsetEvents();
      } else {
        setEvents((java.util.List<SequencedBuildSlaveEvent>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SUCCESS:
      return isSuccess();

    case ERROR_MESSAGE:
      return getErrorMessage();

    case QUERY:
      return getQuery();

    case EVENTS:
      return getEvents();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SUCCESS:
      return isSetSuccess();
    case ERROR_MESSAGE:
      return isSetErrorMessage();
    case QUERY:
      return isSetQuery();
    case EVENTS:
      return isSetEvents();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof BuildSlaveEventsRange)
      return this.equals((BuildSlaveEventsRange)that);
    return false;
  }

  public boolean equals(BuildSlaveEventsRange that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_success = true && this.isSetSuccess();
    boolean that_present_success = true && that.isSetSuccess();
    if (this_present_success || that_present_success) {
      if (!(this_present_success && that_present_success))
        return false;
      if (this.success != that.success)
        return false;
    }

    boolean this_present_errorMessage = true && this.isSetErrorMessage();
    boolean that_present_errorMessage = true && that.isSetErrorMessage();
    if (this_present_errorMessage || that_present_errorMessage) {
      if (!(this_present_errorMessage && that_present_errorMessage))
        return false;
      if (!this.errorMessage.equals(that.errorMessage))
        return false;
    }

    boolean this_present_query = true && this.isSetQuery();
    boolean that_present_query = true && that.isSetQuery();
    if (this_present_query || that_present_query) {
      if (!(this_present_query && that_present_query))
        return false;
      if (!this.query.equals(that.query))
        return false;
    }

    boolean this_present_events = true && this.isSetEvents();
    boolean that_present_events = true && that.isSetEvents();
    if (this_present_events || that_present_events) {
      if (!(this_present_events && that_present_events))
        return false;
      if (!this.events.equals(that.events))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSuccess()) ? 131071 : 524287);
    if (isSetSuccess())
      hashCode = hashCode * 8191 + ((success) ? 131071 : 524287);

    hashCode = hashCode * 8191 + ((isSetErrorMessage()) ? 131071 : 524287);
    if (isSetErrorMessage())
      hashCode = hashCode * 8191 + errorMessage.hashCode();

    hashCode = hashCode * 8191 + ((isSetQuery()) ? 131071 : 524287);
    if (isSetQuery())
      hashCode = hashCode * 8191 + query.hashCode();

    hashCode = hashCode * 8191 + ((isSetEvents()) ? 131071 : 524287);
    if (isSetEvents())
      hashCode = hashCode * 8191 + events.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(BuildSlaveEventsRange other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSuccess()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetErrorMessage()).compareTo(other.isSetErrorMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMessage, other.errorMessage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetQuery()).compareTo(other.isSetQuery());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuery()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.query, other.query);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEvents()).compareTo(other.isSetEvents());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvents()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.events, other.events);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("BuildSlaveEventsRange(");
    boolean first = true;

    if (isSetSuccess()) {
      sb.append("success:");
      sb.append(this.success);
      first = false;
    }
    if (isSetErrorMessage()) {
      if (!first) sb.append(", ");
      sb.append("errorMessage:");
      if (this.errorMessage == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMessage);
      }
      first = false;
    }
    if (isSetQuery()) {
      if (!first) sb.append(", ");
      sb.append("query:");
      if (this.query == null) {
        sb.append("null");
      } else {
        sb.append(this.query);
      }
      first = false;
    }
    if (isSetEvents()) {
      if (!first) sb.append(", ");
      sb.append("events:");
      if (this.events == null) {
        sb.append("null");
      } else {
        sb.append(this.events);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (query != null) {
      query.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BuildSlaveEventsRangeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BuildSlaveEventsRangeStandardScheme getScheme() {
      return new BuildSlaveEventsRangeStandardScheme();
    }
  }

  private static class BuildSlaveEventsRangeStandardScheme extends org.apache.thrift.scheme.StandardScheme<BuildSlaveEventsRange> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BuildSlaveEventsRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SUCCESS
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.success = iprot.readBool();
              struct.setSuccessIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERROR_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMessage = iprot.readString();
              struct.setErrorMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // QUERY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.query = new BuildSlaveEventsQuery();
              struct.query.read(iprot);
              struct.setQueryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EVENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list40 = iprot.readListBegin();
                struct.events = new java.util.ArrayList<SequencedBuildSlaveEvent>(_list40.size);
                SequencedBuildSlaveEvent _elem41;
                for (int _i42 = 0; _i42 < _list40.size; ++_i42)
                {
                  _elem41 = new SequencedBuildSlaveEvent();
                  _elem41.read(iprot);
                  struct.events.add(_elem41);
                }
                iprot.readListEnd();
              }
              struct.setEventsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BuildSlaveEventsRange struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        oprot.writeBool(struct.success);
        oprot.writeFieldEnd();
      }
      if (struct.errorMessage != null) {
        if (struct.isSetErrorMessage()) {
          oprot.writeFieldBegin(ERROR_MESSAGE_FIELD_DESC);
          oprot.writeString(struct.errorMessage);
          oprot.writeFieldEnd();
        }
      }
      if (struct.query != null) {
        if (struct.isSetQuery()) {
          oprot.writeFieldBegin(QUERY_FIELD_DESC);
          struct.query.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.events != null) {
        if (struct.isSetEvents()) {
          oprot.writeFieldBegin(EVENTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.events.size()));
            for (SequencedBuildSlaveEvent _iter43 : struct.events)
            {
              _iter43.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BuildSlaveEventsRangeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BuildSlaveEventsRangeTupleScheme getScheme() {
      return new BuildSlaveEventsRangeTupleScheme();
    }
  }

  private static class BuildSlaveEventsRangeTupleScheme extends org.apache.thrift.scheme.TupleScheme<BuildSlaveEventsRange> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BuildSlaveEventsRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSuccess()) {
        optionals.set(0);
      }
      if (struct.isSetErrorMessage()) {
        optionals.set(1);
      }
      if (struct.isSetQuery()) {
        optionals.set(2);
      }
      if (struct.isSetEvents()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSuccess()) {
        oprot.writeBool(struct.success);
      }
      if (struct.isSetErrorMessage()) {
        oprot.writeString(struct.errorMessage);
      }
      if (struct.isSetQuery()) {
        struct.query.write(oprot);
      }
      if (struct.isSetEvents()) {
        {
          oprot.writeI32(struct.events.size());
          for (SequencedBuildSlaveEvent _iter44 : struct.events)
          {
            _iter44.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BuildSlaveEventsRange struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.success = iprot.readBool();
        struct.setSuccessIsSet(true);
      }
      if (incoming.get(1)) {
        struct.errorMessage = iprot.readString();
        struct.setErrorMessageIsSet(true);
      }
      if (incoming.get(2)) {
        struct.query = new BuildSlaveEventsQuery();
        struct.query.read(iprot);
        struct.setQueryIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list45 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.events = new java.util.ArrayList<SequencedBuildSlaveEvent>(_list45.size);
          SequencedBuildSlaveEvent _elem46;
          for (int _i47 = 0; _i47 < _list45.size; ++_i47)
          {
            _elem46 = new SequencedBuildSlaveEvent();
            _elem46.read(iprot);
            struct.events.add(_elem46);
          }
        }
        struct.setEventsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

