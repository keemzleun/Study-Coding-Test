package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298_2 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){ // 스택이 비어있지 않고, 스택의 값이 현재 값보다 작을때
                arr[stack.pop()] = arr[i]; // 스택의 값을 현재 값으로 바꿔준다.
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1; // 스택이 비어있지 않는경우, 스택의 값을 -1로 바꿔준다.
        }
        //출력
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);
    }
}