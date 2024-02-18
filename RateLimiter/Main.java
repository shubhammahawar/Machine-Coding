/*

ExecutorService executor = Executors.newFixedThreadPool(1);

This line creates a fixed-size thread pool with a single thread. 
The newFixedThreadPool(1) method of the Executors class returns an ExecutorService that uses a single worker thread. 
Tasks submitted to this executor are executed sequentially, meaning one after the other. 
In this case, it's used to execute tasks sequentially in the loop later in the code.

ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);

This line creates a scheduled thread pool with 5 threads. 
The newScheduledThreadPool(5) method of the Executors class returns a ScheduledExecutorService,
which is capable of scheduling tasks to run periodically or after a delay. 
This pool is used to schedule the execution of a task (r in this case) at a fixed rate of 50 milliseconds,
as specified by the scheduledExecutor.scheduleAtFixedRate(r, 0, 50, TimeUnit.MILLISECONDS); line later in the code.

*/





public class Main {

public static void main (String args[]) throws Exception{

  ThrotleRule rule = new ThrotleRule();
  ThrotleRuleService throtleRuleService = ThrotleRuleService.getInstance();
  throtleRuleService.createRule("client",rule);

  UserIdentificationService request = new UserIdentificationService();

  ExecutorService executor=Executor.newFixedThreadPool(1);

  ScheduledExecutorService scheduledExecutor.newScheduledThreadPool(5);

  Long startTime = System.currentTimeMillis();

  Runnable r = () -> { ("client"+ Thread.currentThread.getName()+"--"+request.serveRequest("client"));
    };
  scheduledExecutor.scheduledAtFixedRate(r,0,50,TimeUnit.MILLISECONDS);
  executor.shutdown();
  
  try{
    executor.awaitTermination(LONG.MAX_VALUE, TimeUnit.INMILLISECONDS);
    long endTime = System.currentTimeMillis();
      System.out.printlm("Total Time Taken"+ endTime-startTime);
  }catch(InterruptedExecution e){
    e.printStackTrace();
  }
}
}
