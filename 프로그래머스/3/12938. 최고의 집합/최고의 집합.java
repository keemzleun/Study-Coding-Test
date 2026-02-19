class Solution {
    public int[] solution(int n, int s) {
        if (n > s){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        int quotient = s / n;
        for (int i = 0; i < answer.length; i++){
            answer[i] = quotient;
        }
        
        int remainder = s % n;
        for (int i = 0; i < remainder; i++){
            answer[n - 1 - i]++;
        }
        
        return answer;
    }
}