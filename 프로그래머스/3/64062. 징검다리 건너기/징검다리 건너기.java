class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200000000;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if (canCross(stones, k, mid)){
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
    private boolean canCross(int[] stones, int k, int mid){
        int count = 0;
        for (int stone : stones){
            if (stone < mid) {
                count++;
                if (count == k) return false;
            } else {
                count = 0;
            }   
        }
        return true;
    }
}