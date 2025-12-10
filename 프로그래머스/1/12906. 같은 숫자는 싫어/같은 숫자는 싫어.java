import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        int front = arr[0];
        temp.add(front);
        for (int i=1; i<arr.length; i++){
            if (front != arr[i]){
                front = arr[i];
                temp.add(arr[i]);
            }
        }
        
        int[] answer = new int[temp.size()];
        for (int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }
        
        
        return answer;
    }
}