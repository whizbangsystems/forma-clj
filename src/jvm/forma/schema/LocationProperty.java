/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package forma.schema;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
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

public class LocationProperty implements org.apache.thrift.TBase<LocationProperty, LocationProperty._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LocationProperty");

  private static final org.apache.thrift.protocol.TField PIXEL_LOCATION_FIELD_DESC = new org.apache.thrift.protocol.TField("pixelLocation", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CHUNK_LOCATION_FIELD_DESC = new org.apache.thrift.protocol.TField("chunkLocation", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LocationPropertyStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LocationPropertyTupleSchemeFactory());
  }

  public ModisPixelLocation pixelLocation; // required
  public ModisChunkLocation chunkLocation; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PIXEL_LOCATION((short)1, "pixelLocation"),
    CHUNK_LOCATION((short)2, "chunkLocation");

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
        case 1: // PIXEL_LOCATION
          return PIXEL_LOCATION;
        case 2: // CHUNK_LOCATION
          return CHUNK_LOCATION;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PIXEL_LOCATION, new org.apache.thrift.meta_data.FieldMetaData("pixelLocation", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ModisPixelLocation.class)));
    tmpMap.put(_Fields.CHUNK_LOCATION, new org.apache.thrift.meta_data.FieldMetaData("chunkLocation", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ModisChunkLocation.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LocationProperty.class, metaDataMap);
  }

  public LocationProperty() {
  }

  public LocationProperty(
    ModisPixelLocation pixelLocation,
    ModisChunkLocation chunkLocation)
  {
    this();
    this.pixelLocation = pixelLocation;
    this.chunkLocation = chunkLocation;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LocationProperty(LocationProperty other) {
    if (other.isSetPixelLocation()) {
      this.pixelLocation = new ModisPixelLocation(other.pixelLocation);
    }
    if (other.isSetChunkLocation()) {
      this.chunkLocation = new ModisChunkLocation(other.chunkLocation);
    }
  }

  public LocationProperty deepCopy() {
    return new LocationProperty(this);
  }

  @Override
  public void clear() {
    this.pixelLocation = null;
    this.chunkLocation = null;
  }

  public ModisPixelLocation getPixelLocation() {
    return this.pixelLocation;
  }

  public LocationProperty setPixelLocation(ModisPixelLocation pixelLocation) {
    this.pixelLocation = pixelLocation;
    return this;
  }

  public void unsetPixelLocation() {
    this.pixelLocation = null;
  }

  /** Returns true if field pixelLocation is set (has been assigned a value) and false otherwise */
  public boolean isSetPixelLocation() {
    return this.pixelLocation != null;
  }

  public void setPixelLocationIsSet(boolean value) {
    if (!value) {
      this.pixelLocation = null;
    }
  }

  public ModisChunkLocation getChunkLocation() {
    return this.chunkLocation;
  }

  public LocationProperty setChunkLocation(ModisChunkLocation chunkLocation) {
    this.chunkLocation = chunkLocation;
    return this;
  }

  public void unsetChunkLocation() {
    this.chunkLocation = null;
  }

  /** Returns true if field chunkLocation is set (has been assigned a value) and false otherwise */
  public boolean isSetChunkLocation() {
    return this.chunkLocation != null;
  }

  public void setChunkLocationIsSet(boolean value) {
    if (!value) {
      this.chunkLocation = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PIXEL_LOCATION:
      if (value == null) {
        unsetPixelLocation();
      } else {
        setPixelLocation((ModisPixelLocation)value);
      }
      break;

    case CHUNK_LOCATION:
      if (value == null) {
        unsetChunkLocation();
      } else {
        setChunkLocation((ModisChunkLocation)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PIXEL_LOCATION:
      return getPixelLocation();

    case CHUNK_LOCATION:
      return getChunkLocation();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PIXEL_LOCATION:
      return isSetPixelLocation();
    case CHUNK_LOCATION:
      return isSetChunkLocation();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LocationProperty)
      return this.equals((LocationProperty)that);
    return false;
  }

  public boolean equals(LocationProperty that) {
    if (that == null)
      return false;

    boolean this_present_pixelLocation = true && this.isSetPixelLocation();
    boolean that_present_pixelLocation = true && that.isSetPixelLocation();
    if (this_present_pixelLocation || that_present_pixelLocation) {
      if (!(this_present_pixelLocation && that_present_pixelLocation))
        return false;
      if (!this.pixelLocation.equals(that.pixelLocation))
        return false;
    }

    boolean this_present_chunkLocation = true && this.isSetChunkLocation();
    boolean that_present_chunkLocation = true && that.isSetChunkLocation();
    if (this_present_chunkLocation || that_present_chunkLocation) {
      if (!(this_present_chunkLocation && that_present_chunkLocation))
        return false;
      if (!this.chunkLocation.equals(that.chunkLocation))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_pixelLocation = true && (isSetPixelLocation());
    builder.append(present_pixelLocation);
    if (present_pixelLocation)
      builder.append(pixelLocation);

    boolean present_chunkLocation = true && (isSetChunkLocation());
    builder.append(present_chunkLocation);
    if (present_chunkLocation)
      builder.append(chunkLocation);

    return builder.toHashCode();
  }

  public int compareTo(LocationProperty other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    LocationProperty typedOther = (LocationProperty)other;

    lastComparison = Boolean.valueOf(isSetPixelLocation()).compareTo(typedOther.isSetPixelLocation());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPixelLocation()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pixelLocation, typedOther.pixelLocation);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChunkLocation()).compareTo(typedOther.isSetChunkLocation());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChunkLocation()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.chunkLocation, typedOther.chunkLocation);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LocationProperty(");
    boolean first = true;

    sb.append("pixelLocation:");
    if (this.pixelLocation == null) {
      sb.append("null");
    } else {
      sb.append(this.pixelLocation);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("chunkLocation:");
    if (this.chunkLocation == null) {
      sb.append("null");
    } else {
      sb.append(this.chunkLocation);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LocationPropertyStandardSchemeFactory implements SchemeFactory {
    public LocationPropertyStandardScheme getScheme() {
      return new LocationPropertyStandardScheme();
    }
  }

  private static class LocationPropertyStandardScheme extends StandardScheme<LocationProperty> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LocationProperty struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PIXEL_LOCATION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.pixelLocation = new ModisPixelLocation();
              struct.pixelLocation.read(iprot);
              struct.setPixelLocationIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CHUNK_LOCATION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.chunkLocation = new ModisChunkLocation();
              struct.chunkLocation.read(iprot);
              struct.setChunkLocationIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, LocationProperty struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.pixelLocation != null) {
        oprot.writeFieldBegin(PIXEL_LOCATION_FIELD_DESC);
        struct.pixelLocation.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.chunkLocation != null) {
        oprot.writeFieldBegin(CHUNK_LOCATION_FIELD_DESC);
        struct.chunkLocation.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LocationPropertyTupleSchemeFactory implements SchemeFactory {
    public LocationPropertyTupleScheme getScheme() {
      return new LocationPropertyTupleScheme();
    }
  }

  private static class LocationPropertyTupleScheme extends TupleScheme<LocationProperty> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LocationProperty struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPixelLocation()) {
        optionals.set(0);
      }
      if (struct.isSetChunkLocation()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPixelLocation()) {
        struct.pixelLocation.write(oprot);
      }
      if (struct.isSetChunkLocation()) {
        struct.chunkLocation.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LocationProperty struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.pixelLocation = new ModisPixelLocation();
        struct.pixelLocation.read(iprot);
        struct.setPixelLocationIsSet(true);
      }
      if (incoming.get(1)) {
        struct.chunkLocation = new ModisChunkLocation();
        struct.chunkLocation.read(iprot);
        struct.setChunkLocationIsSet(true);
      }
    }
  }

}
