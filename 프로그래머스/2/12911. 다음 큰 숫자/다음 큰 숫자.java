import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        
        int ones = countOnes(binary);
        
        while (true) {
            n++;
            if (countOnes(Integer.toBinaryString(n)) == ones){
                answer = n;
                break;
            }
        }
        return answer;
    }
    public int countOnes(String binary){
        int ones = 0;
        for (int i=0; i<binary.length(); i++){
            if (binary.charAt(i) == '1'){
                ones++;
            }
        }
        return ones;
    }
}