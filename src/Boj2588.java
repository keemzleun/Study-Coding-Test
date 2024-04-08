import java.util.Scanner;

public class Boj2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        String str1 = b + "";

        for (int i = 2; i >= 0; i--){
            char ch = str1.charAt(i);
            System.out.println(a * (ch-'0'));
        }
        System.out.println(a*b);
    }
}
