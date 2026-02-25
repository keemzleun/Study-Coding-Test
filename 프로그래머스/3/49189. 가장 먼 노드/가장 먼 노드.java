import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        int max = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (int neighbor : graph.get(now)){
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    dist[neighbor] = dist[now] + 1;
                    max = Math.max(max, dist[neighbor]);
                    q.add(neighbor);
                }
            }    
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++){
            if (dist[i] == max) count++;
        }
        
        return count;
        
    }
}