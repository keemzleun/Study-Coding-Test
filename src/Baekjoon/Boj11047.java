package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        for (int i=N-1; i>=0; i--){
            System.out.println(A[i]);
            if (A[i] > K){

            }
        }
    }
}
