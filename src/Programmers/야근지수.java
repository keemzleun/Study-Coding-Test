package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {
    public static void main(String[] args) {
        // 야근 피로도 += 남은 일의 작업량^2
        // 각 work에서 n을 빼서 최소값을 찾아야 함
        int n = 4;  // 퇴근까지 남은 시간
        int[] work = {4, 3, 3};     // 남은 일의 작업량
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : work) {
            pq.add(i);
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (n != 0) {
                num = pq.poll();
                pq.add(num - 1);
            }
        }
        int temp[] = new int[work.length];
        long sum = 0;
        for (int i = 0; i < work.length; i++) {
            if (pq.peek() >= 0){
                sum += (long)Math.pow(pq.poll(), 2);
            } else {
                sum += 0;
            }
        }
        System.out.println(sum);

        // 맞는데 효율성이 망함 -> long 처리
    }
}


