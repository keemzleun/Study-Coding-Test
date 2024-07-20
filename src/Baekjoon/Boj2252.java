package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 학생 수
        int M = Integer.parseInt(st.nextToken());   // 키를 비교할 횟수

        int[] in_degree = new int[N+1];     // 진입차수를 저장할 배열
        List<List<Integer>> adj = new ArrayList<>();
        Deque<Integer> answer = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            in_degree[B]++;
            adj.get(A).add(B);
        }

        for (int i = 1; i <= N; i++) {
            if (in_degree[i] == 0 ){
                answer.add(i);
            }
        }
        while(!answer.isEmpty()){
        int temp = answer.poll();
        System.out.print(temp + " ");
        for(int next : adj.get(temp)){
            in_degree[next]--;
            if (in_degree[next] == 0){
                answer.add(next);
            }
        }
    }
}
}
