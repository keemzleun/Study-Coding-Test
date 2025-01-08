import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            int max = numbers[N-1];
            for (int j = N-2; j >= 0; j--) {
                if (max >= numbers[j]) {
                    sum += max - numbers[j];
                } else {
                    max = numbers[j];
                }
            }
            System.out.println(sum);
        }

    }
}
