import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 교환
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < i+aCnt; j++) {
                int idx = j%str.length();
                if (str.charAt(idx) == 'b') {
                    bCnt++;
                }
            }
            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}
