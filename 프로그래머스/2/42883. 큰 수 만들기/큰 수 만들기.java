import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++){
            char now = number.charAt(i);
            
            while(sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < now) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(now);
        }
        return sb.substring(0, sb.length() - k);
    }
}