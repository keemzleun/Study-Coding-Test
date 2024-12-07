import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class Main {

    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        answer = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        dfs(1, 1);

        for (int i = 2; i < N+1; i++) {
            System.out.println(answer[i]);
        }

    }
    static void dfs(int start, int parent){
        answer[start] = parent;
        for(int target : adjList.get(start)){
            if (answer[target] == 0){
                dfs(target, start);
            }
        }
    }
}
