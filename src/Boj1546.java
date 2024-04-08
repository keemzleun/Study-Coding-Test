import java.util.Scanner;

public class Boj1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int A[] = new int[num];
        for (int i = 0; i < num; i++){
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i=0; i<num; i++){
            if(A[i]>max) max = A[i];
            sum += A[i];
        }
        System.out.println(sum*100.0/max/num);
    }
}
