import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for(int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for(int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for(int j = 0; j < str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            if(first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {   
                result++;
            } else if (first.length() == str.length() - 1 && str.length() - 1 == cnt) {   
                result++;
            } else if (first.length() == str.length() + 1 && str.length() == cnt) {   
                result++;
            }

        }
        System.out.println(result);

    }
}