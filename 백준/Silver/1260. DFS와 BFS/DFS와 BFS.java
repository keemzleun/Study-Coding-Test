import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// dfs와 bfs
public class Main {

    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        // 정점 번호 작은 순서로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);

    }
    static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for (int target : adjList.get(start)){
            if (visited[target] == false){
                dfs(target);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for (int target : adjList.get(temp)) {
                if (!visited[target]){
                    q.add(target);
                    visited[target] = true;
                }
            }
        }
    }
}
