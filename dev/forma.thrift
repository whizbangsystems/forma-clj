namespace java forma.schema

struct FireTuple {
  1: i32 temp330;
  2: i32 conf50;
  3: i32 bothPreds;
  4: i32 count;
}

struct FormaValue {
  1: FireTuple fireValue;
  2: double shortDrop;
  3: double longDrop;
  4: double tStat;
  5: optional double paramBreak;
}

struct NeighborValue {
  1: FireTuple fireValue;
  2: i32 numNeighbors;
  3: double avgShortDrop;
  4: double minShortDrop;
  5: double avgLongDrop;
  6: double minLongDrop;
  7: double avgTStat;
  8: double minTStat;
  9: optional double avgParamBreak;
  10: optional double minParamBreak;
}

# Collection Wrappers

struct ShortArray {
  1: list<i16> shorts
}

struct IntArray {
  1: list<i32> ints
}

struct LongArray {
  1: list<i64> longs
}

struct DoubleArray {
  1: list<double> doubles
}

struct FireSeries {
  1: i32 startIdx;
  2: i32 endIdx;
  3: list<FireTuple> values;
}

struct FormaSeries {
  1: list<FormaValue> values;
}

union ArrayValue {
  1: LongArray longs;
  2: DoubleArray doubles;
  3: ShortArray shorts;
  4: IntArray ints;
}


struct TimeSeries {
  1: i32 startIdx;
  2: i32 endIdx;
  3: ArrayValue series;
}

union DataValue {
  1: DoubleArray doubles;
  2: IntArray ints;
  3: LongArray longs;
  4: ShortArray shorts;
  5: double doubleVal;
  6: FireSeries fireSeries;
  7: FireTuple fireVal;
  8: i32 intVal;
  9: i64 longVal;
  10: i16 shortVal;
  11: TimeSeries timeSeries;
}

struct ModisPixelLocation {
  1: string resolution;
  2: i32 tileH;
  3: i32 tileV;
  4: i32 sample;
  5: i32 line;
}

struct ModisChunkLocation {
  1: string resolution;
  2: i32 tileH;
  3: i32 tileV;
  4: i32 chunkID;
  5: i32 chunkSize;
}

union LocationPropertyValue {
  1: ModisPixelLocation pixelLocation;
  2: ModisChunkLocation chunkLocation;
}

struct LocationProperty {
  1: LocationPropertyValue property;
}

struct DataChunk {
  1: string dataset;
  2: LocationProperty locationProperty;
  3: DataValue chunkValue;
  4: string temporalRes;
  5: optional string date;
}
