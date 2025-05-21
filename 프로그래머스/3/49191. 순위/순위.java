class Solution {
    public int solution(int n, int[][] results) {
       int answer = 0;

        boolean[][] graph = new boolean[n+1][n+1];

        for(int[] result : results){
            graph[result[0]][result[1]] = true;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            int win = 0;
            int lose = 0;
            for (int j = 1; j <= n ; j++) {
                if (graph[i][j]) win++;
                if (graph[j][i]) lose++;
            }

            if (win + lose == n - 1){
                answer++;
            }
        }

        return answer;
    }
}