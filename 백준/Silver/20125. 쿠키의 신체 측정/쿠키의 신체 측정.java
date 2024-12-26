import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿠키의 신체 측정
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int heartX = -1, heartY = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*'
                        && i + 1 < N && board[i + 1][j] == '*'
                        && j - 1 >= 0 && board[i][j - 1] == '*'
                        && j + 1 < N && board[i][j + 1] == '*') {
                    heartX = i;
                    heartY = j;
                }
            }
        }

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

        // 왼쪽 팔
        for (int j = heartY - 1; j >= 0 && board[heartX][j] == '*'; j--) {
            leftArm++;
        }

        // 오른쪽 팔
        for (int j = heartY + 1; j < N && board[heartX][j] == '*'; j++) {
            rightArm++;
        }

        // 허리
        for (int i = heartX + 1; i < N && board[i][heartY] == '*'; i++) {
            waist++;
        }

        // 왼쪽 다리
        for (int i = heartX + waist + 1; i < N && board[i][heartY - 1] == '*'; i++) {
            leftLeg++;
        }

        // 오른쪽 다리
        for (int i = heartX + waist + 1; i < N && board[i][heartY + 1] == '*'; i++) {
            rightLeg++;
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
