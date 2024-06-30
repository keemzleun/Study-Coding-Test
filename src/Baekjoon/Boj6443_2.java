package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj6443_2{
    static int len;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextLine().charAt(0) - '0';
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            char[] s = temp.toCharArray();
            len = s.length;
            Arrays.sort(s);
            visited = new boolean[len];
            dfs(s, new StringBuilder(),0);
        }
    }
    public static void dfs(char[] arr, StringBuilder sb, int depth) {
        if (depth == len) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
//            if (!visited[i]) {
            if (visited[i]) continue;   // visited[i]가 true면 continue
            // 인덱스 넘어가지 않게 &&중복 &&
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue; // 중복된 문자열이 있을 경우.

            visited[i] = true;
            sb.append(arr[i]);
            dfs(arr,  sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}