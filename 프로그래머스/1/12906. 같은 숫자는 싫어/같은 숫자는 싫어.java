import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       Deque<Integer> dq = new LinkedList<>();
        for(int i : arr){
            if (dq.isEmpty()){
                dq.add(i);
            } else {
                if (dq.peekLast() != i) dq.add(i);
            }
        }
        int[] answer = dq.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}