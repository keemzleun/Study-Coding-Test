import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 순열 사이클
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;

            for (int j = 1; j <= n ; j++) {
                if (!visited[j]){
                    bfs(arr, j, visited);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int[] arr, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int next = arr[x];

            if (!visited[next]) {
                visited[next] = true;
                queue.add(next);
            }
        }
    }
}
