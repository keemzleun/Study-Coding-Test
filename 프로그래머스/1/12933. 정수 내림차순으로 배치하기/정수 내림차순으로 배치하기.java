import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] stArr = String.valueOf(n).split("");
        
        Arrays.sort(stArr);
        
        String result = "";
        for (int i = stArr.length - 1; i >= 0; i--){
            result += stArr[i];
        }
        return Long.parseLong(result);
    }
}