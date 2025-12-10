import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int front = arr[0];
        answer.add(front);
        for (int i=1; i<arr.length; i++){
            if (front != arr[i]){
                front = arr[i];
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}