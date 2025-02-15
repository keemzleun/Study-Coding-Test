import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 쉬운 최단거리
public class Main {
    static int n, m;
    static int[][] map, dist;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1,-1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    x = i;
                    y = j;
                }
                if (map[i][j] == 1) {
                    dist[i][j] = -1;
                }
            }
        }

        bfs(x, y);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0], curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[curX][curY] + 1;
            }
        }
    }
}
