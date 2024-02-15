public class TokenBucket implements RateLimiter{

private final long maxBucketSize;
private final long refillRate;
private double currentBucketSize;
private long lastRefillTimeStamp;

  public TokenBucket(long maxBucketSize, long refillRate){
    this.maxBucketSize = maxBucketSize;
    this.refillRate = refillRate;
    this.currentBucketSize = maxBucketSize;
    this.lastRefillTimeStamp = System.nanoTime();
  }

  @Override
  public synchronized boolean allowRequest(){
    refill();

    if(currentBucketSize>=1){
      currentBucketSize-=1;
      return true;
  }
    return false;
  }

  void refill(){
    long now = System.nanoTime();
    long tokenAdded = (now-lastRefillTimeStamp)*refillRate/1e9;
    System.out.println("before refilled:"+currentBucketSize);
    currentBucketSize = Math.min(tokenAdded+currentBucketSize, maxBucketSize);
     System.out.println("after refilled:"+currentBucketSize);
    lastRefillTimeStamp = now;
  
