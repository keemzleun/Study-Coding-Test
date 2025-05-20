import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (distance[next] == -1 ){
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }

        int max = 0;
        for(int d : distance){
            max = Math.max(max, d);
        }

        int count = 0;
        for(int d : distance) {
            if (d == max) count++;
        }

        return count;
    }
}