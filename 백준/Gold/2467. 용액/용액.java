import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (start < end){
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                a = arr[start];
                b = arr[end];
            }

            if (sum < 0) {
                start++;
            } else if (sum == 0) {
                min = sum;
                break;
            } else {
                end--;
            }
        }
        System.out.println(a +" "+ b);


    }
}
