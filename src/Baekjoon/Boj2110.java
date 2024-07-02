package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1];

        for (int i = 1; i < N; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(S);

        int left = 1;
        int right = S[N] - S[1];
        int distance = 0;
        int answer = 0;

        while (left <= right){
            int middle = (left+right) / 2;
            int start = S[1];
            int count = 1;
            for (int i = 1; i <= N ; i++) {
                distance = S[i] - start;
                if (distance >= middle){
                    count++;
                    start = S[i];
                }
            }
            if (count>= C){
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;

            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();


    }
}
