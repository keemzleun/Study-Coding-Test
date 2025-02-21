import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            String str = bf.readLine();
            int k = Integer.parseInt(bf.readLine());

            if (k == 1) { 
                System.out.println("1 1"); 
                continue; 
            }

            // 각 문자의 등장 인덱스를 저장할 리스트 배열
            List<Integer>[] alpha = new ArrayList[26];
            for (int j = 0; j < 26; j++) {
                alpha[j] = new ArrayList<>();
            }

            // 문자열 순회하며 문자별 등장 위치 저장
            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a'].add(j);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            // a-z 각각의 문자에 대해 확인
            for (int j = 0; j < 26; j++) {
                if (alpha[j].size() < k) continue; // k번 미만으로 등장하는 문자 무시

                // 슬라이딩 윈도우 탐색
                for (int l = 0; l <= alpha[j].size() - k; l++) {
                    int len = alpha[j].get(l + k - 1) - alpha[j].get(l) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }
}
