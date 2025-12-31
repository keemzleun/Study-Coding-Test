import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++){
            for (int j = 0; j < triangle[i].length; j++){
                if (j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j-1], triangle[i][j] + dp[i-1][j]);
                }   
            }     
        }
        
        for (int i : dp[triangle.length - 1]){
            if (i > answer) answer = i;
        }
        
        return answer;
    }
}