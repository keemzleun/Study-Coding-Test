package Baekjoon;

import java.util.Scanner;

public class Boj11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];

        for(int i=0; i<N; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                a[i] += x;
            } else if (x==0) {

            }
        }
    }
}
