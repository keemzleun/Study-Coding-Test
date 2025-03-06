import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]){
                    dfs(j);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int start){
        visited[start] = true;
        int next = arr[start]; // 현재 노드가 가리키는 다음 노드

        if (!visited[next]){  // 다음 노드를 방문하지 않았다면 계속 탐색
            dfs(next);
        }
    }
}
