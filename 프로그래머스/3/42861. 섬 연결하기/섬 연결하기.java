import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : costs){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{0, 0});
        
        int count = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int to = curr[0];
            int cost = curr[1];
            
            if (visited[to]) continue;
            
            visited[to] = true;
            answer += cost;
            count++;
            
            if (count == n) break;
            
            for (int[] next : adj[to]){
                if (!visited[next[0]]){
                    pq.add(next);
                }
            }
        }
        
        
        return answer;
    }
}