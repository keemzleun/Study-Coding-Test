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
        int[] A = new int[N];
        int answer = 0;
        
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i=N-1; i>=0; i--){
            if (A[i] <= K){
                answer += (K / A[i]);
                K = (K % A[i]);
            }
        }
        System.out.println(answer);
    }
}
