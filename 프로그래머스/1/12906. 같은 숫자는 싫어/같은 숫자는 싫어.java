import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<>();

        int last = arr[0];
        q.add(last);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != last) {
                q.add(arr[i]);
                last = arr[i];
            }
        }

        int[] answer = new int[q.size()];
        int idx = 0;
        while (!q.isEmpty()) {
            answer[idx++] = q.poll();
        }

        return answer;
    }
}
