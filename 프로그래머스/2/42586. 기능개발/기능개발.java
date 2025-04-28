import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int n = progresses.length;
        int day = 0; 
        int count = 0; 

        for (int i = 0; i < n; i++) {
            int needDay = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            
            if (day < needDay) { 
                if (count > 0) {
                    result.add(count);
                }
                day = needDay;
                count = 1;
            } else {
                count++;
            }
        }
        
        result.add(count); 

        return result.stream().mapToInt(i -> i).toArray();
    }
}
