package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수2 {
    public static void main(String[] args) {
        int n = 1;
        int[] works = {2,1,2};
        long answer = 0;
        // 야근 피로도 = 남은 일의 작업량^2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : works){
            pq.add(w);
        }
        for (int i = 0; i < n; i++) {
            if (pq.peek()!= 0){
                int temp = pq.poll()-1;
                pq.add(temp);
            }
        }
        while(!pq.isEmpty()) {
            answer += (long)Math.pow(pq.poll(), 2);
            System.out.println(answer);
        }
        System.out.println(answer);

    }
}
