package Baekjoon;

import java.util.Scanner;

public class Boj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 1;
        int start = 1;
        int last = 1;
        int count = 1;

        while(last != N) {
            if (sum == N) {
                count++;
                last++;
                sum = sum + last;
            } else if (sum < N) {
                last++;
                sum = sum + last;
            } else if (sum > N) {
                sum = sum - start;
                start++;
            }
        }
        System.out.println(count);
    }
}
