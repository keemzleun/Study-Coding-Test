import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파티
public class Main {
    static int n, m, x;
    static ArrayList<Node>[] list, reverseList;
    static int[] distToX, distFromX;
    static class Node implements Comparable<Node> {
        int d;
        int cost;
        public Node(int d, int cost){
            this.d = d;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n){
            return this.cost - n.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 학생수
        m = Integer.parseInt(st.nextToken());   // 도로의 개수
        x = Integer.parseInt(st.nextToken());   // 파티가 열리는 마을

        list = new ArrayList[n+1];
        reverseList = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            reverseList[end].add(new Node(start, cost));
        }

        distFromX = dijkstra(x, list);
        distToX = dijkstra(x, reverseList);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.println(maxTime);

        }
    public static int[] dijkstra(int start, List<Node>[] graph){
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node current = q.poll();
            int now = current.d;

            if (current.cost > dist[now]) continue;

            for (Node next : graph[now]) {
                if (dist[next.d] > dist[now] + next.cost) {
                    dist[next.d] = dist[now] + next.cost;
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }
        return dist;
    }
}

