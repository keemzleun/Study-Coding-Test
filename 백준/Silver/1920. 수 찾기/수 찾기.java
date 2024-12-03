import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int low = 0;
            int high = A.length - 1;
            boolean found = false;

            while (low <= high){
                int mid = (low + high) / 2;
                if (A[mid] == arrM[i]) {
                    System.out.println(1);
                    found = true;
                    break;
                } else if (A[mid] < arrM[i]) {
                    low = mid + 1; // 오른쪽 탐색
                } else {
                    high = mid - 1; // 왼쪽 탐색
                }
            }

            if (!found) {
                System.out.println(0); // 값을 찾지 못한 경우
            }

        }

    }
}
