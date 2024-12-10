import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 예산
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        while (min <= max) {
            int mid = (min + max) / 2;
            long budget = 0;
            for (int i = 0; i < N; i++) {
                budget += Math.min(arr[i], mid);
            }
            if (budget <= M) {
                min = mid + 1;
            } else {
                max = mid -1;
            }
        }
        System.out.println(max);

    }
}
