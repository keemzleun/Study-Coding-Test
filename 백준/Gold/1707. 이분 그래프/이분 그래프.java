import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] check;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K ; i++) {  // K = 테스트 케이스 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   // V = 정점의 개수
            int E = Integer.parseInt(st.nextToken());   // E = 간선의 개수

            adj = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int [V+1];
            IsEven = true;

            for (int j = 1; j <= V; j++) {
                adj[j] = new ArrayList<Integer>();
            }

            // 에지 데이터 저장하기
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adj[start].add(end);
                adj[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    check[j] = 0;  // 시작 정점을 0으로 설정
                    dfs(j);
                }
                if (!IsEven) break;
            }

            if (IsEven) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int start){
        visited[start] = true;
        for (int target : adj[start]){  // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색
            if (!visited[target]){
                // 바로 직전에 있는 노드와 다른 집합으로 분류해주기
                check[target] = (check[start] + 1) % 2;
                dfs(target);
            }
            else {
               if (check[start] == check[target]) {
                   IsEven = false;
               }
            }
        }
    }
}
