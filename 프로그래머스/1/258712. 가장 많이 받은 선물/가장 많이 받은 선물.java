import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int f_len = friends.length;
        int[][] record = new int[f_len][f_len];
        
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String friend : friends){
            map.put(friend, index);
            index++;
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] splits = gifts[i].split(" ");
            String giver = splits[0];
            String reciver = splits[1];
            
            int g_num = map.get(giver);
            int r_num = map.get(reciver);
            record[g_num][r_num]++; // 주고 받은 기록
            record[g_num][g_num]++; // 선물 지수
            record[r_num][r_num]--; // 선물 지수  
        }
        
        int maxGifts = 0;
        for (int i = 0; i < f_len; i++) {
            int currentFrientGifts = 0;
            for (int j = 0; j < f_len; j++) {
                if (i == j) continue;

                // 1. 주고받은 횟수 비교
                if (record[i][j] > record[j][i]) {
                    currentFrientGifts++;
                } 
                // 2. 횟수가 같거나 기록이 없는 경우 (0으로 같음)
                else if (record[i][j] == record[j][i]) {
                    if (record[i][i] > record[j][j]) {
                        currentFrientGifts++;
                    }
                }
            }
            maxGifts = Math.max(maxGifts, currentFrientGifts);
        }
        return maxGifts;
    }
}