import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minMove = len - 1;
        
        for (int i = 0; i < len; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            // 좌우 이동
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            
            int moveBack = (i*2) + (len - next);
            minMove = Math.min(minMove, moveBack);
            
            int moveFront = (len - next) * 2 + i;
            minMove = Math.min(minMove, moveFront);
        }
        return answer + minMove;
    }
}