import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

// 음식물 피하기
public class Main {

    static int N, M, K;
    static boolean[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j]) {
                    count=0;
                    bfs(i,j);
                    answer = Math.max(answer, count);
                }
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        count++;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for (int k = 0; k < 4; k++) {
                int xx = temp.x + dx[k];
                int yy = temp.y + dy[k];
                if(xx<0 || yy<0 || xx>=N || yy>=M)continue;
                if(!visited[xx][yy] && arr[xx][yy]) {
                    q.add(new Point(xx, yy));
                    visited[xx][yy]=true;
                    count++;
                }
            }
        }
    }
}
