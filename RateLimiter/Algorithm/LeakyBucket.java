public class LeakyBucket implements RateLimiter{

BlockingQueue<Integer> queue;

public LeakyBucket(){
this.queue = new LinkedBlockingQueue<>(Config.leakCapacity);
}

@Override
  public synchronized boolean allowRequest(){
  if(queue.remainingCapacity()>0){
    queue.add(1);
    return true;
  }
    return false;
  }
}
