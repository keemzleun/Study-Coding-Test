import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        long[] cost = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];

        for (int i = 0; i < N-1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * distance[i]);
        }

        System.out.println(sum);
    }
}
