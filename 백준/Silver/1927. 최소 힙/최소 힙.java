import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0){
                queue.add(input);
            } else if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(queue.poll());
            }
        }
    }
}
