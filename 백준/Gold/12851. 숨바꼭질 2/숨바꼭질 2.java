import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        findMinTime(n, k);

    }
    public static void findMinTime(int n, int k){
        if (n == k){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        int max = 100000;
        int[] visited = new int[max + 1];
        int[] count = new int[max + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;
        count[n] = 1;

        int min = Integer.MAX_VALUE;
        int ways = 0;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int nx : new int[]{x-1, x+1, x*2}){
                if (nx < 0 || nx > max) continue;

                // 처음 방문하는 경우
                if (visited[nx] == 0) {
                    visited[nx] = visited[x] + 1;
                    count[nx] = count[x]; // 방법의 개수는 이전 위치에서 가져옴
                    queue.add(nx);
                }
                // 같은 최단 시간에 도달한 경우, 방법의 개수를 추가
                else if (visited[nx] == visited[x] + 1) {
                    count[nx] += count[x];
                }
            }
        }
        System.out.println(visited[k] - 1); // 시작을 1로 설정했으므로 1을 빼줌
        System.out.println(count[k]);
    }
}
