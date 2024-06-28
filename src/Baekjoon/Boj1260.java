package Baekjoon;

import java.util.*;

public class Boj1260 {
    static List<List<Integer>> dfsList;
    static List<List<Integer>> bfsList;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 정점의 개수
        int M = sc.nextInt();       // 간선의 개수
        int V = sc.nextInt();       // 시작 정점의 번호

        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            dfsList.add(new ArrayList<>());
            bfsList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dfsList.get(a).add(b);
            dfsList.get(b).add(a);

            bfsList.get(a).add(b);
            bfsList.get(b).add(a);
        }

        dfs(V);
        bfs(V);

    }
    static void dfs(int start){
//        System.out.print(start + " ");
        visited[start] = true;
        for (int target : dfsList.get(start)){
            if (visited[target] == false){
                dfs(target);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.println(temp + " ");
            for (int target : bfsList.get(temp)) {
                // target을 queue에 add하기 전에 true로 세팅
                if (!visited[target]){
                    q.add(target);
                    visited[target] = true;
                }
            }
        }
    }
}
