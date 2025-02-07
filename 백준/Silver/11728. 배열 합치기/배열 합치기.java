import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 합치기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] Array = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N+M; i++) {
            Array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Array);
        StringBuilder sb = new StringBuilder();
        for (int num : Array) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}