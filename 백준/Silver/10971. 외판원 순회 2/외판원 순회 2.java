import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 1, 0);
        }
        System.out.println(min);

    }
    public static void dfs(int start, int now, int count, int cost){
        if (cost >= min) return;

        if (count == n){
            if (map[now][start] != 0){
                min = Math.min(min, cost + map[now][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0){
                visited[i] = true;
                dfs(start, i, count + 1, cost + map[now][i]);
                visited[i] = false;
            }
        }
    }
}
