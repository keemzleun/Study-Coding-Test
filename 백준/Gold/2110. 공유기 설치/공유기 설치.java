import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int low = 1;
        int high = home[N-1];

        while(low <= high){
            int mid = (low + high) / 2;

            int position = 0;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (home[i] - home[position] >= mid){
                    position = i;
                    cnt++;
                }
            }
            if (cnt < C) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        System.out.println(low - 1);
    }
}
