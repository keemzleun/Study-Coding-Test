import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// IF문 좀 대신 써줘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] level = new String[N];
        int[] score = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            level[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            int index = binarySearch(score, input);
            sb.append(level[index] + "\n");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int[] score, int input){
        int left = 0;
        int right = score.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (input <= score[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
