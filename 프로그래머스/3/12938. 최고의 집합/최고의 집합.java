class Solution {
    public int[] solution(int n, int s) {
        if (n > s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        
        int value = s / n;
        for(int i=0; i<n; i++){
            answer[i] = value;
        }
        
        int remainder = s % n;
        if (remainder != 0){
            for(int i=0; i<remainder; i++){
                answer[n-1-i]++;
            }
        }
        
        return answer;
    }
}