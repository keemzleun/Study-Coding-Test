import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 구간 합 계산
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }

        int max = sum;
        int count = 1;

        for (int i = X; i < N; i++) {
            sum += visitors[i];     // 새로운 값을 더하고
            sum -= visitors[i - X]; // 오래된 값을 빼줌
            
            if (sum > max) {
                max = sum;
                count = 1;  // 새로운 최대값이 나오면 count 초기화
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
