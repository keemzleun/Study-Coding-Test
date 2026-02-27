class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double length = arr.length;
        double sum = 0;
        for (int a : arr){
            sum += a;
        }
        answer = sum / length;
        return answer;
    }
}