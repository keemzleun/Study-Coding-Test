import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
        }
        Arrays.sort(S);

        int i = 0;
        int j = N-1;
        while(i<j) {
            if (S[i] + S[j] < M) i++; 
            else if(S[i] + S[j] > M) j--;
            else {
                count++;
                i++; j--;
            }
        }
        System.out.println(count);
    }
}
