import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 0;
        long right = times[times.length - 1] * (long)n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int t : times) {
                sum += mid / t;
            }

            if (sum < n){
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}