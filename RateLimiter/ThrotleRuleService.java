public class ThrottleRuleService {
  
  HashMap<String, ThrotleRule>clientThrotleRule;
  private static volatile ThrotleRuleService instance;

  public ThrotleRuleService(){
  clientThrotleRule = new HashMap<>();
  }

  public void createRule(String clientId, ThrotleRule throtleRule){
  clientThrotleRule.put(clientId, throtleRule);
  }

  public ThrotleRule getClientRules(String clientId){
  return clientThrotleRules.get(clientId);
  }

  public static ThortleRuleService getInstance(){

    if(instance==null){
      synchronized(ThrotleRuleService.class){
        if(instance==null){
          insatnce = new ThrotleRuleService();
  }
      }
    }
    return instance;
  }
}

  
  
