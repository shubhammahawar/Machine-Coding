public class ThrotleRule{

public long bucketSize;
public long refillRate;

public ThrotleRule(){
  bucketSize=10;
  refillRate=10;
}

public ThrotleRule(long bucketSize, long refillRate){
this.bucketSize=bucketSize;
this.refillRtae=refillRate;  
}

  public long getBucketSize(){
    return bucketSize;
  }

public long refillRate(){
  return refillRate;
}
}
  
