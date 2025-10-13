class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliverCount = 0;
        int pickupCount = 0;
        
        for (int i = n - 1; i >= 0; i--){
            deliverCount += deliveries[i];
            pickupCount += pickups[i];
            
            while (deliverCount > 0 || pickupCount > 0){
                answer += (long)(i + 1) * 2;
                
                deliverCount -= cap;
                pickupCount -= cap;
            }
        }
        
        
        return answer;
    }
}