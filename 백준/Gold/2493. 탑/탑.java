import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑
class Top {
    int idx;
    int h;

    Top (int idx, int h){
        this.idx = idx;
        this.h = h;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
           int h = Integer.parseInt(st.nextToken());
           if (stack.isEmpty()) {
               sb.append("0 ");
               stack.push(new Top(i, h));
           } else {
               while (true) {
                   if (stack.isEmpty()) {
                       sb.append("0 ");
                       stack.push(new Top(i, h));
                       break;
                   }
                   Top top = stack.peek();
                   if (top.h > h){
                       sb.append(top.idx + " ");
                       stack.push(new Top(i, h));
                       break;
                   } else {
                       stack.pop();
                   }

               }
           }
        }
        System.out.println(sb);

    }
}
