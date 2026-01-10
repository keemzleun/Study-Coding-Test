class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1;
        int sum = 0;
        while(start <= n){
            if (sum < n){
                sum += end;
                end++;
            } else if(sum == n){
                answer++;
                sum -= start;
                start++;
            } else {
                sum -= start;
                start++;
            }
        }
        return answer;
    }
}