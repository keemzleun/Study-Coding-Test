import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int pNum = 0;
        int yNum = 0;
        
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'p'){
                pNum++;
            } else if (ch == 'y'){
                yNum++;
            }
        }
        
        if (pNum != yNum) answer = false;
        

        return answer;
    }
}