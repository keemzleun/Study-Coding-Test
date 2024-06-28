package Baekjoon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj17086_3 {
    public static void main(String[] args) {
        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};     //우 좌 하 상 우하 우상 좌하 좌상
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int n, m;
        int[][] map;
        int[][] dist;
        Queue<int[]> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dist = new int[n][m];
        // 지도에 표시 및 큐에 넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    // 상어가 있는 곳 queue에 넣기
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

//            팔방탐색
            for(int i = 0; i < 8; i++){ //우 좌 하 상 우하 우상 좌하 좌상
                int nx = x + dx[i];
                int ny = y + dy[i];
//                범위안에 있고, 상어가 없는 곳이라면
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0){
                    map[nx][ny] = 1; // 상어가 간 곳은 1로 표시
                    dist[nx][ny] = dist[x][y] + 1; // 거리를 1 증가
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer = Math.max(answer, dist[i][j]);
            }
        }
        System.out.println(answer);
    }
}