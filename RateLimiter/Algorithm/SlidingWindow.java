public class SlidingWindow implements RateLimiter{

long bucketSize;
long timeWindowInSeconds;
Queue<long>queue;

public SlidingWindow(long bucketSize, long timeWinowInSeconds){
this.bucketSie=bucketSize;
this.timeWindowInSeconds=timeWindowInSeconds;
this.queue = new ConcurrentLinkedQueue<Long>();
}

@Override
  public synchronized boolean allowRequest(){
    Long currentTime = System.CurrentTimeMillis();
    checkAndUpdate(currentTime);
    if(queue.size()<bucketSize){
      queue.offer(currentTime);
      return true;
  }
    return false;
  }

  public void checkAndUpdate(long currentTime){
    if(queue.isEmpty()){
    return;
    }
    
  long time = currentTime-queue.peek()/1000;
  while(!queue.isEmpty() && time>=timeWindowInseconds){
      queue.poll();

      if(!queue.isEmpty())
        time = currentTime-queue.peek()/1000;
      
  }
  }
}

