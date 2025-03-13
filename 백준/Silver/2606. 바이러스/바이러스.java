import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 바이러스
public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        list = new ArrayList[C+1];
        for (int i = 1; i <= C; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[C+1];
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int answer = dfs(1);

        System.out.println(answer == 0 ? 0 : answer - 1);;

    }
    static int dfs(int start){
        for (int i : list[start]){
            if (!visited[i]){
                visited[i] = true;
                count++;
                dfs(i);
            }
        }

        return count;
    }
}
