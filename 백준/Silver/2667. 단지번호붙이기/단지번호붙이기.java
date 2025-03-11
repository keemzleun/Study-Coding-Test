import java.io.*;
import java.util.*;

// 단지번호붙이기
public class Main {
    static boolean[][] visited;
    static int count, n;
    static int[][] apt;
    static int[] x = {0 , 0, -1, 1};
    static int[] y = {-1 , 1, 0, 0};
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        apt = new int[n][n];
        visited = new boolean[n][n];
        answer = new LinkedList<>();
        count = 1;

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                apt[i][j] = st.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apt[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    answer.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int a : answer){
            System.out.println(a);
        }
    }
    static void dfs(int i, int j){
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x[k] + i;
            int ny = y[k] + j;

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && apt[nx][ny] == 1){
                count++;
                dfs(nx, ny);
            }
        }
    }
}
