import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 반복수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> d = new ArrayList<>();
        d.add(a);

        while(true) {
            int temp = d.get(d.size() - 1);
            int result = 0;
            while(temp != 0){
                result += (int) Math.pow(temp % 10, (double) p);
                temp /= 10;
            }

            if (d.contains(result)){
                int answer = d.indexOf(result);
                System.out.println(answer);
                break;
            }
            d.add(result);
        }

    }
}
