import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int [] count = new int[100001];
        int start = 0, end = 0;
        int answer = 0;

        while (end < N) {
            while (end < N && count[numbers[end]] + 1 <= K) {
                count[numbers[end++]]++;
            }
            int len = end - start;
            answer = Math.max(answer, len);

            count[numbers[start++]]--;
        }

        System.out.print(answer);
    }
}