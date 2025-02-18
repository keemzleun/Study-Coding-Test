import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class Main {

    static int max = 100000;
    static int[] visited = new int[max + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }
    static int bfs(int start, int target){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1; // 시작 위치 방문 처리 (0초가 아니라 1부터 시작)

        while(!q.isEmpty()){
            int now = q.poll();

            if (now == target){
                return visited[now] - 1; // 처음 위치를 1로 시작했으므로 1 빼줌
            }

            int[] nextPos = {now - 1, now + 1, now * 2};

            for (int next : nextPos) {
                if (next >= 0 && next <= max && visited[next] == 0){
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }

        return -1;
    }
}
