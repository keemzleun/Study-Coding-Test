class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int range = 2 * w + 1;
        
        for (int s : stations){
            int left = s - w;
            
            if (now < left){
                int gap = left - now;
                
                answer += gap / range;
                if (gap % range != 0) answer++;
            }
            
            now = s + w + 1;
        }
        
        if (now <= n){
            int gap = n - now + 1;
            answer += gap / range;
            if (gap % range != 0) answer++;
        }

        return answer;
    }
}