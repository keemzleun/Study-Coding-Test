import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타노스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int strLength = str.length();
        int oneCnt = 0, zeroCnt = 0;
        char[] chars = new char[strLength];

        for (int i = 0; i < strLength; i++) {
            chars[i] = str.charAt(i);
            if (chars[i] == '1') oneCnt++;
            else zeroCnt++;
        }

        oneCnt /= 2;
        zeroCnt /= 2;

        for (int i = 0; i < strLength && oneCnt != 0; i++) {
            if (chars[i] == '1'){
                oneCnt--;
                chars[i] = 0;
            }
        }

        for (int i = strLength - 1; i >= 0 && zeroCnt != 0; i--) {
            if (chars[i] == '0'){
                zeroCnt--;
                chars[i] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            if (chars[i] != 0){
                sb.append(chars[i]);
            }
        }

        System.out.println(sb);

    }
}
