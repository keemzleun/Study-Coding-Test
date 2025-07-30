import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer>  q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];    // 남은 작업량
            int days = remaining / speeds[i];       // 소요일수
            if (remaining % speeds[i] != 0) days++;
            q.offer(days);
        }

        ArrayList<Integer> deployments = new ArrayList<>();

        while(!q.isEmpty()){
            int first = q.poll();
            int count = 1;

            while(!q.isEmpty() && q.peek() <= first){
                q.poll();
                count++;
            }

            deployments.add(count);
        }

        return deployments.stream().mapToInt(Integer::intValue).toArray();
    }
}