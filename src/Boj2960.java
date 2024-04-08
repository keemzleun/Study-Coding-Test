import java.util.Scanner;

public class Boj2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] list = new boolean[n+1];

        int cnt = 0;
        // 2부터 N까지 모든 정수 적기
        for (int i = 2; i <= n; i++) {

            // i부터 i의 배수를 true값으로 변환
            for(int j = i; j <= n; j += i ){
                if(list[j] == false) {
                    cnt++;
                    list[j] = true;
                }
                //cnt값이 k와 같아지면 j를 출력
                if (cnt == k) {
                    System.out.println(j);
                    // System.exit(0);
                    return;
                }
            }
        }
    }
}
