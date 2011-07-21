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

public class DoubleArray implements TBase<DoubleArray, DoubleArray._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("DoubleArray");

  private static final TField DOUBLES_FIELD_DESC = new TField("doubles", TType.LIST, (short)1);

  public List<Double> doubles;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    DOUBLES((short)1, "doubles");

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
        case 1: // DOUBLES
          return DOUBLES;
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
    tmpMap.put(_Fields.DOUBLES, new FieldMetaData("doubles", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new FieldValueMetaData(TType.DOUBLE))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(DoubleArray.class, metaDataMap);
  }

  public DoubleArray() {
  }

  public DoubleArray(
    List<Double> doubles)
  {
    this();
    this.doubles = doubles;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DoubleArray(DoubleArray other) {
    if (other.isSetDoubles()) {
      List<Double> __this__doubles = new ArrayList<Double>();
      for (Double other_element : other.doubles) {
        __this__doubles.add(other_element);
      }
      this.doubles = __this__doubles;
    }
  }

  public DoubleArray deepCopy() {
    return new DoubleArray(this);
  }

  @Override
  public void clear() {
    this.doubles = null;
  }

  public int getDoublesSize() {
    return (this.doubles == null) ? 0 : this.doubles.size();
  }

  public java.util.Iterator<Double> getDoublesIterator() {
    return (this.doubles == null) ? null : this.doubles.iterator();
  }

  public void addToDoubles(double elem) {
    if (this.doubles == null) {
      this.doubles = new ArrayList<Double>();
    }
    this.doubles.add(elem);
  }

  public List<Double> getDoubles() {
    return this.doubles;
  }

  public DoubleArray setDoubles(List<Double> doubles) {
    this.doubles = doubles;
    return this;
  }

  public void unsetDoubles() {
    this.doubles = null;
  }

  /** Returns true if field doubles is set (has been asigned a value) and false otherwise */
  public boolean isSetDoubles() {
    return this.doubles != null;
  }

  public void setDoublesIsSet(boolean value) {
    if (!value) {
      this.doubles = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DOUBLES:
      if (value == null) {
        unsetDoubles();
      } else {
        setDoubles((List<Double>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DOUBLES:
      return getDoubles();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DOUBLES:
      return isSetDoubles();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DoubleArray)
      return this.equals((DoubleArray)that);
    return false;
  }

  public boolean equals(DoubleArray that) {
    if (that == null)
      return false;

    boolean this_present_doubles = true && this.isSetDoubles();
    boolean that_present_doubles = true && that.isSetDoubles();
    if (this_present_doubles || that_present_doubles) {
      if (!(this_present_doubles && that_present_doubles))
        return false;
      if (!this.doubles.equals(that.doubles))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_doubles = true && (isSetDoubles());
    builder.append(present_doubles);
    if (present_doubles)
      builder.append(doubles);

    return builder.toHashCode();
  }

  public int compareTo(DoubleArray other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DoubleArray typedOther = (DoubleArray)other;

    lastComparison = Boolean.valueOf(isSetDoubles()).compareTo(typedOther.isSetDoubles());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoubles()) {
      lastComparison = TBaseHelper.compareTo(this.doubles, typedOther.doubles);
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
        case 1: // DOUBLES
          if (field.type == TType.LIST) {
            {
              TList _list0 = iprot.readListBegin();
              this.doubles = new ArrayList<Double>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                double _elem2;
                _elem2 = iprot.readDouble();
                this.doubles.add(_elem2);
              }
              iprot.readListEnd();
            }
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
    if (this.doubles != null) {
      oprot.writeFieldBegin(DOUBLES_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.DOUBLE, this.doubles.size()));
        for (double _iter3 : this.doubles)
        {
          oprot.writeDouble(_iter3);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DoubleArray(");
    boolean first = true;

    sb.append("doubles:");
    if (this.doubles == null) {
      sb.append("null");
    } else {
      sb.append(this.doubles);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

