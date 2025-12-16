import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for (int i=0; i<phone_book.length-1; i++){
            if (check(phone_book[i], phone_book[i+1])) answer=false;
        }
        return answer;
    }
    boolean check(String st1, String st2){
        for (int i=0; i<st1.length(); i++){
            if (st1.charAt(i) != st2.charAt(i)) return false;
        }
        return true;
    }
}