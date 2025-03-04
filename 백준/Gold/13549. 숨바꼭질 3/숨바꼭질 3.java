import java.util.*;

// 숨바꼭질 3
public class Main {
    public static int findMinTime(int N, int K) {
        if (N >= K) {
            return N - K; // N이 K보다 크면 뒤로 걷기만 하면 됨
        }

        int MAX = 100000;
        int[] visited = new int[MAX + 1]; // 방문 시간 저장
        Arrays.fill(visited, -1);

        Deque<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            // 동생을 찾으면 종료
            if (x == K) {
                return visited[x];
            }

            // 순간이동 (우선 처리)
            if (2 * x <= MAX && visited[2 * x] == -1) {
                visited[2 * x] = visited[x]; // 0초 소요
                queue.addFirst(2 * x); // 순간이동을 먼저 처리
            }

            // 걷기 (X-1, X+1)
            for (int nx : new int[]{x - 1, x + 1}) {
                if (nx >= 0 && nx <= MAX && visited[nx] == -1) {
                    visited[nx] = visited[x] + 1;
                    queue.add(nx);
                }
            }
        }
        return -1; // 도달할 수 없는 경우 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(findMinTime(N, K));
    }
}
