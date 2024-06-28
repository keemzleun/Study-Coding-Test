package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj17086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] sqr = new int[N][M];
        int[][] copy =new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sqr[i][j] = sc.nextInt();
            }
        }
        // System.out.println(Arrays.deepToString(sqr));
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});  // x, y, distance
        // 1 상 2
        // 좌 * 우
        // 3 하 4
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        visited[0][0] = true;
        while (!q.isEmpty()){
            int[] current = q.poll();
            for( int i=0; i<8; i++ ) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int dis = current[2];
                if (nx > 0 || nx <= M || ny > 0 || nx <= N){

                }

            }
        }



    }
}
