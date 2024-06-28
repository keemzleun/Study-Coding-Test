package Baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    // 오큰수: 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수
    // 없을 경우 -1 리턴
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        A[N] = 0;
        for (int i = 0; i < N; i++){
            for (int j = N; j > i; j--) {
                if (A[j] > A[i]) {
                    stack.add(A[j]);
                }
                if (A[j] == 0) {
                    stack.add(-1);
                }
            }
            int answer = stack.pop();
            bw.write(answer + " ");

        }
        bw.flush();
        bw.close();
    }
}
