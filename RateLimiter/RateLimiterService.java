public class RateLimiterService{

  HashMap<String,ThrotleRule>clientRulesCache;
  HashMap<String, RateLimiter>rateLimiterHashMap;
  ThrotleRuleService throtleRuleService;

  public RateLimiterService(){
    this.clientRulesCache = new HashMap<>();
    this.rateLimiterHashMap = new HashMap<>();
    this.throtleRuleService = ThrotleRuleService.getInstance();
}

public boolean isRateLimitedUserRequest(String clientId){
  createUserIfNotTheir(clientId);
  return rateLimiterHashMap.get(clientId).allowRequest();
}

void createUserIfNotTheir(String clientId){
  if(!clientRulesCache.containsKey(clientId)){
    ThrotleRule clientRules=throtleRuleService.getClientRules(clientId);
    clientRulesCache.put(clientId, clientRules);
  }
  if(!rateLimiterHashMap.containsKey(clientId)){
    ThrotleRule throtleRule = clientRulesCache.get(clientId);
    RateLimiter rateLimiter=new TokenBucket(throtleRule.getBucketSize(), throtleRule.getRateLimiter());
    rateLimiterHashMap.put(clientId, rateLimiter);
  }
}
}
