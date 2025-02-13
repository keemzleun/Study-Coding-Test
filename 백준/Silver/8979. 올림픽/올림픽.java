import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 올림픽
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int kGold = 0, kSilver = 0, kBronze = 0;
        int[][] nations = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
            if (nations[i][0] == k) {
                kGold = nations[i][1];
                kSilver = nations[i][2];
                kBronze = nations[i][3];
            }
        }
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (nations[i][1] > kGold ||
                    (nations[i][1] == kGold && nations[i][2] > kSilver) ||
                    (nations[i][1] == kGold && nations[i][2] == kSilver && nations[i][3] > kBronze)) {
                rank++; 
            }
        }
        System.out.println(rank);


    }
}
