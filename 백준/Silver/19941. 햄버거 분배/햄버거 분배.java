import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 분배
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] arr = new char[n];
        arr = s.toCharArray();

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P'){
                for (int j = -k; j <= k; j++) {
                    if (i+j >= n) break;
                    if (i+j < 0) continue;

                    if (arr[i+j] == 'H' && visited[i+j] == false){
                        visited[i+j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
