package Baekjoon;

import java.util.Scanner;

public class Boj8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        String[] s = new String[testCase];

        for (int i = 0; i < testCase; i++) {
            s[i] = sc.next();
        }
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            int temp = 0;
            for(int j = 0; j < s[i].length(); j++) {
                char ch = s[i].charAt(j);
                if (ch == 'O') {
                    temp++;
                    answer += temp;
                } else if (ch == 'X') {
                    temp = 0;
                }
            }
            System.out.println(answer);
        }
    }
}
