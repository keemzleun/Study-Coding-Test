package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수_효율성보완 {
    public static void main(String[] args) {
        // 야근 피로도 += 남은 일의 작업량^2
        // 각 work에서 n을 빼서 최소값을 찾아야 함
        int n = 4;  // 퇴근까지 남은 시간
        int[] works = {4, 3, 3};     // 남은 일의 작업량
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: works){
            pq.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty() )break;
            int temp = pq.poll();
            pq.add(temp-1);
        }

        long sum = 0;
        while(!pq.isEmpty()){
            int temp = pq.poll();
            if (temp > 0){
                sum += (long)temp*temp;
            }
        }
        System.out.println(sum);
    }
}
