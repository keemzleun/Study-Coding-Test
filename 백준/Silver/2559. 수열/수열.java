import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ondo = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ondo[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < K; i++) {
            sum += ondo[i];
        }
        max = sum;

        for (int i = K; i < N; i++) {
            sum = sum - ondo[i-K] + ondo[i];
            if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}
