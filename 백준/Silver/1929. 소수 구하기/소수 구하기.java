import java.io.*;
import java.util.StringTokenizer;

// 소수 구하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];
        check[0] = true;
        check[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if(!check[i]) {
                for(int j = i * i; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if(!check[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
