/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package forma.schema;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class TimeSeries implements TBase<TimeSeries, TimeSeries._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("TimeSeries");

  private static final TField START_IDX_FIELD_DESC = new TField("startIdx", TType.I32, (short)1);
  private static final TField END_IDX_FIELD_DESC = new TField("endIdx", TType.I32, (short)2);
  private static final TField SERIES_FIELD_DESC = new TField("series", TType.STRUCT, (short)3);

  public int startIdx;
  public int endIdx;
  public ArrayValue series;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    START_IDX((short)1, "startIdx"),
    END_IDX((short)2, "endIdx"),
    SERIES((short)3, "series");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // START_IDX
          return START_IDX;
        case 2: // END_IDX
          return END_IDX;
        case 3: // SERIES
          return SERIES;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __STARTIDX_ISSET_ID = 0;
  private static final int __ENDIDX_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.START_IDX, new FieldMetaData("startIdx", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.END_IDX, new FieldMetaData("endIdx", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
    tmpMap.put(_Fields.SERIES, new FieldMetaData("series", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, ArrayValue.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(TimeSeries.class, metaDataMap);
  }

  public TimeSeries() {
  }

  public TimeSeries(
    int startIdx,
    int endIdx,
    ArrayValue series)
  {
    this();
    this.startIdx = startIdx;
    setStartIdxIsSet(true);
    this.endIdx = endIdx;
    setEndIdxIsSet(true);
    this.series = series;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TimeSeries(TimeSeries other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.startIdx = other.startIdx;
    this.endIdx = other.endIdx;
    if (other.isSetSeries()) {
      this.series = new ArrayValue(other.series);
    }
  }

  public TimeSeries deepCopy() {
    return new TimeSeries(this);
  }

  @Override
  public void clear() {
    setStartIdxIsSet(false);
    this.startIdx = 0;
    setEndIdxIsSet(false);
    this.endIdx = 0;
    this.series = null;
  }

  public int getStartIdx() {
    return this.startIdx;
  }

  public TimeSeries setStartIdx(int startIdx) {
    this.startIdx = startIdx;
    setStartIdxIsSet(true);
    return this;
  }

  public void unsetStartIdx() {
    __isset_bit_vector.clear(__STARTIDX_ISSET_ID);
  }

  /** Returns true if field startIdx is set (has been asigned a value) and false otherwise */
  public boolean isSetStartIdx() {
    return __isset_bit_vector.get(__STARTIDX_ISSET_ID);
  }

  public void setStartIdxIsSet(boolean value) {
    __isset_bit_vector.set(__STARTIDX_ISSET_ID, value);
  }

  public int getEndIdx() {
    return this.endIdx;
  }

  public TimeSeries setEndIdx(int endIdx) {
    this.endIdx = endIdx;
    setEndIdxIsSet(true);
    return this;
  }

  public void unsetEndIdx() {
    __isset_bit_vector.clear(__ENDIDX_ISSET_ID);
  }

  /** Returns true if field endIdx is set (has been asigned a value) and false otherwise */
  public boolean isSetEndIdx() {
    return __isset_bit_vector.get(__ENDIDX_ISSET_ID);
  }

  public void setEndIdxIsSet(boolean value) {
    __isset_bit_vector.set(__ENDIDX_ISSET_ID, value);
  }

  public ArrayValue getSeries() {
    return this.series;
  }

  public TimeSeries setSeries(ArrayValue series) {
    this.series = series;
    return this;
  }

  public void unsetSeries() {
    this.series = null;
  }

  /** Returns true if field series is set (has been asigned a value) and false otherwise */
  public boolean isSetSeries() {
    return this.series != null;
  }

  public void setSeriesIsSet(boolean value) {
    if (!value) {
      this.series = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case START_IDX:
      if (value == null) {
        unsetStartIdx();
      } else {
        setStartIdx((Integer)value);
      }
      break;

    case END_IDX:
      if (value == null) {
        unsetEndIdx();
      } else {
        setEndIdx((Integer)value);
      }
      break;

    case SERIES:
      if (value == null) {
        unsetSeries();
      } else {
        setSeries((ArrayValue)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case START_IDX:
      return new Integer(getStartIdx());

    case END_IDX:
      return new Integer(getEndIdx());

    case SERIES:
      return getSeries();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case START_IDX:
      return isSetStartIdx();
    case END_IDX:
      return isSetEndIdx();
    case SERIES:
      return isSetSeries();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TimeSeries)
      return this.equals((TimeSeries)that);
    return false;
  }

  public boolean equals(TimeSeries that) {
    if (that == null)
      return false;

    boolean this_present_startIdx = true;
    boolean that_present_startIdx = true;
    if (this_present_startIdx || that_present_startIdx) {
      if (!(this_present_startIdx && that_present_startIdx))
        return false;
      if (this.startIdx != that.startIdx)
        return false;
    }

    boolean this_present_endIdx = true;
    boolean that_present_endIdx = true;
    if (this_present_endIdx || that_present_endIdx) {
      if (!(this_present_endIdx && that_present_endIdx))
        return false;
      if (this.endIdx != that.endIdx)
        return false;
    }

    boolean this_present_series = true && this.isSetSeries();
    boolean that_present_series = true && that.isSetSeries();
    if (this_present_series || that_present_series) {
      if (!(this_present_series && that_present_series))
        return false;
      if (!this.series.equals(that.series))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_startIdx = true;
    builder.append(present_startIdx);
    if (present_startIdx)
      builder.append(startIdx);

    boolean present_endIdx = true;
    builder.append(present_endIdx);
    if (present_endIdx)
      builder.append(endIdx);

    boolean present_series = true && (isSetSeries());
    builder.append(present_series);
    if (present_series)
      builder.append(series);

    return builder.toHashCode();
  }

  public int compareTo(TimeSeries other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TimeSeries typedOther = (TimeSeries)other;

    lastComparison = Boolean.valueOf(isSetStartIdx()).compareTo(typedOther.isSetStartIdx());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartIdx()) {
      lastComparison = TBaseHelper.compareTo(this.startIdx, typedOther.startIdx);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEndIdx()).compareTo(typedOther.isSetEndIdx());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndIdx()) {
      lastComparison = TBaseHelper.compareTo(this.endIdx, typedOther.endIdx);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSeries()).compareTo(typedOther.isSetSeries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSeries()) {
      lastComparison = TBaseHelper.compareTo(this.series, typedOther.series);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // START_IDX
          if (field.type == TType.I32) {
            this.startIdx = iprot.readI32();
            setStartIdxIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // END_IDX
          if (field.type == TType.I32) {
            this.endIdx = iprot.readI32();
            setEndIdxIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SERIES
          if (field.type == TType.STRUCT) {
            this.series = new ArrayValue();
            this.series.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(START_IDX_FIELD_DESC);
    oprot.writeI32(this.startIdx);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(END_IDX_FIELD_DESC);
    oprot.writeI32(this.endIdx);
    oprot.writeFieldEnd();
    if (this.series != null) {
      oprot.writeFieldBegin(SERIES_FIELD_DESC);
      this.series.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TimeSeries(");
    boolean first = true;

    sb.append("startIdx:");
    sb.append(this.startIdx);
    first = false;
    if (!first) sb.append(", ");
    sb.append("endIdx:");
    sb.append(this.endIdx);
    first = false;
    if (!first) sb.append(", ");
    sb.append("series:");
    if (this.series == null) {
      sb.append("null");
    } else {
      sb.append(this.series);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

