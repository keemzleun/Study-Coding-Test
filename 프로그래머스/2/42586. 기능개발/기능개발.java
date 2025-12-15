import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQ = new LinkedList<>();
    
        for (int i = 0; i < progresses.length; i++){
            int remaining = 100 - progresses[i];
            int days = (int) Math.ceil((double)remaining/speeds[i]);
            dayQ.offer(days);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!dayQ.isEmpty()){
            int max = dayQ.poll();
            int deploy = 1;
            
            while (!dayQ.isEmpty() && dayQ.peek() <= max){
                dayQ.poll();
                deploy++;
            }
            
            list.add(deploy);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}