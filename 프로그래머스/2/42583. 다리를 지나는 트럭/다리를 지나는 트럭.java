import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int index = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            time++;

            totalWeight -= bridge.poll();

            if (totalWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                totalWeight += truck_weights[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        return time + bridge_length;
    }
}