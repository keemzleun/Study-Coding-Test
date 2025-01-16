import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a == b) {
                // 두 값이 같을 경우
                if (o1 <= o2){
                    // a가 b보다 작거나 같을 경우, a에게 높은 우선 순위
                    return -1;
                } else {
                    //  b가 a보다 작거나 같을 경우, b에게 높은 우선 순위
                    return 1;
                }
            } else if (a < b){
                // a가 b보다 작은 절대값을 가질 경우, a에게 높은 우선 순위
                return -1;
            } else {
                // a가 b보다 큰 절대값을 가질 경우, b에게 높은 우선 순위
                return 1;
            }

        });

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());

            if (input == 0) {
                if (pq.isEmpty()){
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll()+"\n");
                }
            } else {
                pq.add(input);
            }
        }
        bw.flush();
        bw.close();
    }
}
