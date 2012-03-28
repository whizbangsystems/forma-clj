/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package forma.schema;

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

public class DataChunk implements TBase<DataChunk, DataChunk._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("DataChunk");

  private static final TField DATASET_FIELD_DESC = new TField("dataset", TType.STRING, (short)1);
  private static final TField TEMPORAL_RES_FIELD_DESC = new TField("temporalRes", TType.STRING, (short)3);
  private static final TField TILE_STRING_FIELD_DESC = new TField("tileString", TType.STRING, (short)4);
  private static final TField LOCATION_PROPERTY_FIELD_DESC = new TField("locationProperty", TType.STRUCT, (short)5);
  private static final TField CHUNK_VALUE_FIELD_DESC = new TField("chunkValue", TType.STRUCT, (short)6);
  private static final TField DATE_FIELD_DESC = new TField("date", TType.STRING, (short)7);

  public String dataset;
  public String temporalRes;
  public String tileString;
  public LocationProperty locationProperty;
  public DataValue chunkValue;
  public String date;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    DATASET((short)1, "dataset"),
    TEMPORAL_RES((short)3, "temporalRes"),
    TILE_STRING((short)4, "tileString"),
    LOCATION_PROPERTY((short)5, "locationProperty"),
    CHUNK_VALUE((short)6, "chunkValue"),
    DATE((short)7, "date");

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
        case 1: // DATASET
          return DATASET;
        case 3: // TEMPORAL_RES
          return TEMPORAL_RES;
        case 4: // TILE_STRING
          return TILE_STRING;
        case 5: // LOCATION_PROPERTY
          return LOCATION_PROPERTY;
        case 6: // CHUNK_VALUE
          return CHUNK_VALUE;
        case 7: // DATE
          return DATE;
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

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATASET, new FieldMetaData("dataset", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.TEMPORAL_RES, new FieldMetaData("temporalRes", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.TILE_STRING, new FieldMetaData("tileString", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.LOCATION_PROPERTY, new FieldMetaData("locationProperty", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, LocationProperty.class)));
    tmpMap.put(_Fields.CHUNK_VALUE, new FieldMetaData("chunkValue", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, DataValue.class)));
    tmpMap.put(_Fields.DATE, new FieldMetaData("date", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(DataChunk.class, metaDataMap);
  }

  public DataChunk() {
  }

  public DataChunk(
    String dataset,
    String temporalRes,
    String tileString,
    LocationProperty locationProperty,
    DataValue chunkValue)
  {
    this();
    this.dataset = dataset;
    this.temporalRes = temporalRes;
    this.tileString = tileString;
    this.locationProperty = locationProperty;
    this.chunkValue = chunkValue;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DataChunk(DataChunk other) {
    if (other.isSetDataset()) {
      this.dataset = other.dataset;
    }
    if (other.isSetTemporalRes()) {
      this.temporalRes = other.temporalRes;
    }
    if (other.isSetTileString()) {
      this.tileString = other.tileString;
    }
    if (other.isSetLocationProperty()) {
      this.locationProperty = new LocationProperty(other.locationProperty);
    }
    if (other.isSetChunkValue()) {
      this.chunkValue = new DataValue(other.chunkValue);
    }
    if (other.isSetDate()) {
      this.date = other.date;
    }
  }

  public DataChunk deepCopy() {
    return new DataChunk(this);
  }

  @Override
  public void clear() {
    this.dataset = null;
    this.temporalRes = null;
    this.tileString = null;
    this.locationProperty = null;
    this.chunkValue = null;
    this.date = null;
  }

  public String getDataset() {
    return this.dataset;
  }

  public DataChunk setDataset(String dataset) {
    this.dataset = dataset;
    return this;
  }

  public void unsetDataset() {
    this.dataset = null;
  }

  /** Returns true if field dataset is set (has been asigned a value) and false otherwise */
  public boolean isSetDataset() {
    return this.dataset != null;
  }

  public void setDatasetIsSet(boolean value) {
    if (!value) {
      this.dataset = null;
    }
  }

  public String getTemporalRes() {
    return this.temporalRes;
  }

  public DataChunk setTemporalRes(String temporalRes) {
    this.temporalRes = temporalRes;
    return this;
  }

  public void unsetTemporalRes() {
    this.temporalRes = null;
  }

  /** Returns true if field temporalRes is set (has been asigned a value) and false otherwise */
  public boolean isSetTemporalRes() {
    return this.temporalRes != null;
  }

  public void setTemporalResIsSet(boolean value) {
    if (!value) {
      this.temporalRes = null;
    }
  }

  public String getTileString() {
    return this.tileString;
  }

  public DataChunk setTileString(String tileString) {
    this.tileString = tileString;
    return this;
  }

  public void unsetTileString() {
    this.tileString = null;
  }

  /** Returns true if field tileString is set (has been asigned a value) and false otherwise */
  public boolean isSetTileString() {
    return this.tileString != null;
  }

  public void setTileStringIsSet(boolean value) {
    if (!value) {
      this.tileString = null;
    }
  }

  public LocationProperty getLocationProperty() {
    return this.locationProperty;
  }

  public DataChunk setLocationProperty(LocationProperty locationProperty) {
    this.locationProperty = locationProperty;
    return this;
  }

  public void unsetLocationProperty() {
    this.locationProperty = null;
  }

  /** Returns true if field locationProperty is set (has been asigned a value) and false otherwise */
  public boolean isSetLocationProperty() {
    return this.locationProperty != null;
  }

  public void setLocationPropertyIsSet(boolean value) {
    if (!value) {
      this.locationProperty = null;
    }
  }

  public DataValue getChunkValue() {
    return this.chunkValue;
  }

  public DataChunk setChunkValue(DataValue chunkValue) {
    this.chunkValue = chunkValue;
    return this;
  }

  public void unsetChunkValue() {
    this.chunkValue = null;
  }

  /** Returns true if field chunkValue is set (has been asigned a value) and false otherwise */
  public boolean isSetChunkValue() {
    return this.chunkValue != null;
  }

  public void setChunkValueIsSet(boolean value) {
    if (!value) {
      this.chunkValue = null;
    }
  }

  public String getDate() {
    return this.date;
  }

  public DataChunk setDate(String date) {
    this.date = date;
    return this;
  }

  public void unsetDate() {
    this.date = null;
  }

  /** Returns true if field date is set (has been asigned a value) and false otherwise */
  public boolean isSetDate() {
    return this.date != null;
  }

  public void setDateIsSet(boolean value) {
    if (!value) {
      this.date = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATASET:
      if (value == null) {
        unsetDataset();
      } else {
        setDataset((String)value);
      }
      break;

    case TEMPORAL_RES:
      if (value == null) {
        unsetTemporalRes();
      } else {
        setTemporalRes((String)value);
      }
      break;

    case TILE_STRING:
      if (value == null) {
        unsetTileString();
      } else {
        setTileString((String)value);
      }
      break;

    case LOCATION_PROPERTY:
      if (value == null) {
        unsetLocationProperty();
      } else {
        setLocationProperty((LocationProperty)value);
      }
      break;

    case CHUNK_VALUE:
      if (value == null) {
        unsetChunkValue();
      } else {
        setChunkValue((DataValue)value);
      }
      break;

    case DATE:
      if (value == null) {
        unsetDate();
      } else {
        setDate((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATASET:
      return getDataset();

    case TEMPORAL_RES:
      return getTemporalRes();

    case TILE_STRING:
      return getTileString();

    case LOCATION_PROPERTY:
      return getLocationProperty();

    case CHUNK_VALUE:
      return getChunkValue();

    case DATE:
      return getDate();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATASET:
      return isSetDataset();
    case TEMPORAL_RES:
      return isSetTemporalRes();
    case TILE_STRING:
      return isSetTileString();
    case LOCATION_PROPERTY:
      return isSetLocationProperty();
    case CHUNK_VALUE:
      return isSetChunkValue();
    case DATE:
      return isSetDate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DataChunk)
      return this.equals((DataChunk)that);
    return false;
  }

  public boolean equals(DataChunk that) {
    if (that == null)
      return false;

    boolean this_present_dataset = true && this.isSetDataset();
    boolean that_present_dataset = true && that.isSetDataset();
    if (this_present_dataset || that_present_dataset) {
      if (!(this_present_dataset && that_present_dataset))
        return false;
      if (!this.dataset.equals(that.dataset))
        return false;
    }

    boolean this_present_temporalRes = true && this.isSetTemporalRes();
    boolean that_present_temporalRes = true && that.isSetTemporalRes();
    if (this_present_temporalRes || that_present_temporalRes) {
      if (!(this_present_temporalRes && that_present_temporalRes))
        return false;
      if (!this.temporalRes.equals(that.temporalRes))
        return false;
    }

    boolean this_present_tileString = true && this.isSetTileString();
    boolean that_present_tileString = true && that.isSetTileString();
    if (this_present_tileString || that_present_tileString) {
      if (!(this_present_tileString && that_present_tileString))
        return false;
      if (!this.tileString.equals(that.tileString))
        return false;
    }

    boolean this_present_locationProperty = true && this.isSetLocationProperty();
    boolean that_present_locationProperty = true && that.isSetLocationProperty();
    if (this_present_locationProperty || that_present_locationProperty) {
      if (!(this_present_locationProperty && that_present_locationProperty))
        return false;
      if (!this.locationProperty.equals(that.locationProperty))
        return false;
    }

    boolean this_present_chunkValue = true && this.isSetChunkValue();
    boolean that_present_chunkValue = true && that.isSetChunkValue();
    if (this_present_chunkValue || that_present_chunkValue) {
      if (!(this_present_chunkValue && that_present_chunkValue))
        return false;
      if (!this.chunkValue.equals(that.chunkValue))
        return false;
    }

    boolean this_present_date = true && this.isSetDate();
    boolean that_present_date = true && that.isSetDate();
    if (this_present_date || that_present_date) {
      if (!(this_present_date && that_present_date))
        return false;
      if (!this.date.equals(that.date))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(DataChunk other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DataChunk typedOther = (DataChunk)other;

    lastComparison = Boolean.valueOf(isSetDataset()).compareTo(typedOther.isSetDataset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDataset()) {
      lastComparison = TBaseHelper.compareTo(this.dataset, typedOther.dataset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTemporalRes()).compareTo(typedOther.isSetTemporalRes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTemporalRes()) {
      lastComparison = TBaseHelper.compareTo(this.temporalRes, typedOther.temporalRes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTileString()).compareTo(typedOther.isSetTileString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTileString()) {
      lastComparison = TBaseHelper.compareTo(this.tileString, typedOther.tileString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLocationProperty()).compareTo(typedOther.isSetLocationProperty());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLocationProperty()) {
      lastComparison = TBaseHelper.compareTo(this.locationProperty, typedOther.locationProperty);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChunkValue()).compareTo(typedOther.isSetChunkValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChunkValue()) {
      lastComparison = TBaseHelper.compareTo(this.chunkValue, typedOther.chunkValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDate()).compareTo(typedOther.isSetDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDate()) {
      lastComparison = TBaseHelper.compareTo(this.date, typedOther.date);
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
        case 1: // DATASET
          if (field.type == TType.STRING) {
            this.dataset = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TEMPORAL_RES
          if (field.type == TType.STRING) {
            this.temporalRes = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // TILE_STRING
          if (field.type == TType.STRING) {
            this.tileString = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // LOCATION_PROPERTY
          if (field.type == TType.STRUCT) {
            this.locationProperty = new LocationProperty();
            this.locationProperty.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // CHUNK_VALUE
          if (field.type == TType.STRUCT) {
            this.chunkValue = new DataValue();
            this.chunkValue.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // DATE
          if (field.type == TType.STRING) {
            this.date = iprot.readString();
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
    if (this.dataset != null) {
      oprot.writeFieldBegin(DATASET_FIELD_DESC);
      oprot.writeString(this.dataset);
      oprot.writeFieldEnd();
    }
    if (this.temporalRes != null) {
      oprot.writeFieldBegin(TEMPORAL_RES_FIELD_DESC);
      oprot.writeString(this.temporalRes);
      oprot.writeFieldEnd();
    }
    if (this.tileString != null) {
      oprot.writeFieldBegin(TILE_STRING_FIELD_DESC);
      oprot.writeString(this.tileString);
      oprot.writeFieldEnd();
    }
    if (this.locationProperty != null) {
      oprot.writeFieldBegin(LOCATION_PROPERTY_FIELD_DESC);
      this.locationProperty.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.chunkValue != null) {
      oprot.writeFieldBegin(CHUNK_VALUE_FIELD_DESC);
      this.chunkValue.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.date != null) {
      if (isSetDate()) {
        oprot.writeFieldBegin(DATE_FIELD_DESC);
        oprot.writeString(this.date);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DataChunk(");
    boolean first = true;

    sb.append("dataset:");
    if (this.dataset == null) {
      sb.append("null");
    } else {
      sb.append(this.dataset);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("temporalRes:");
    if (this.temporalRes == null) {
      sb.append("null");
    } else {
      sb.append(this.temporalRes);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tileString:");
    if (this.tileString == null) {
      sb.append("null");
    } else {
      sb.append(this.tileString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("locationProperty:");
    if (this.locationProperty == null) {
      sb.append("null");
    } else {
      sb.append(this.locationProperty);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("chunkValue:");
    if (this.chunkValue == null) {
      sb.append("null");
    } else {
      sb.append(this.chunkValue);
    }
    first = false;
    if (isSetDate()) {
      if (!first) sb.append(", ");
      sb.append("date:");
      if (this.date == null) {
        sb.append("null");
      } else {
        sb.append(this.date);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
