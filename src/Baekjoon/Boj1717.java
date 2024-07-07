package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        // 대표 노드를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int zeroOne = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (zeroOne == 0) {
                union(arr, a, b);
            } else if (zeroOne == 1) {
                if (find(arr, a) == find(arr, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int find(int[] arr, int x){
        // arr[x]의 대표 노드가 x가 아니면 대표 노드 찾아가기
        if (arr[x] != x){
            arr[x] = find(arr, arr[x]);     // 경로 압축
        }
        return arr[x];
    }
    public static void union(int[] arr, int a, int b){
        int parentA = find(arr, a);
        int parentB = find(arr, b);
        if (parentA != parentB){
            arr[parentB] = parentA;
        }
    }
}
