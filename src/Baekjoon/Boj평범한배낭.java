package Baekjoon;

import java.util.Scanner;

public class Boj평범한배낭 {

    static Integer[][] dp;
    static int[] W; // weight
    static int[] V; // value

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 물품의 수
        int n = sc.nextInt();
        // 버틸 수 있는 무게
        int k = sc.nextInt();
        // 물품의 무게(0)와 가치(1)
        int[][] a = new int[n+1][2];

        // 행: 물품의 무게, 열: 1~k까지의 무게, 값: 물품의 가치 누적
        int[][] dp = new int[n+1][k+1];

        // 물품들의 무게와 가치 입력
        for(int i=1;i<n+1;i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        // 0행, 0열은 공백 인덱스로 비워둔다.
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<k+1;j++) {
                // 비교 무게 - 물품의 무게 >= 0 인 경우,
                if(j - a[i][0] >= 0) {
                    // 이전 dp에 저장된 누적 가치와 자신의 가치+남은 무게의 가치 중 큰 값을 취한다.
                    // 점화식은 기본적으로 dp[i][j]의 값은 dp [i-1][j]의 값을 가진다.
                    // 왜냐하면, 2번 아이템의 경우 무게가 2일 때까지 2번 아이템은 저장하지 못하므로, 1번 아이템에서 구해놓은 가치를 저장해둔다.
                    dp[i][j] = Math.max( dp[i-1][j], a[i][1]+dp[i-1][j-a[i][0]]);
                }else {
                    // 나머지는 이전 dp에 누적된 가치를 취한다.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);

        sc.close();
    }

}

