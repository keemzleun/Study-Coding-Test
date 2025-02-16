import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 볼 모으기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int ballsLength = balls.length();
        int count = 0, red = 0, blue = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < ballsLength; i++) {
            if (balls.charAt(i) == 'R') {
                red++;
            } else {
                blue++;
            }
        }

        // 빨간색 공을 왼쪽으로
        int index = 0;
        count = 0;
        for (int i = 0; i < ballsLength; i++) {
            if (balls.charAt(i) == 'R'){
                index++;
            } else {
                count++;
            }
            if (index == red){
                break;
            }
        }
        min = Math.min(min, count);


        // 빨간색 공을 오른쪽으로
        index = 0;
        count = 0;
        for (int i = ballsLength - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R'){
                index++;
            } else {
                count++;
            }
            if (index == red){
                break;
            }
        }
        min = Math.min(min, count);

        // 파란색 공을 왼쪽으로
        index = 0;
        count = 0;
        for (int i = 0; i < ballsLength; i++) {
            if (balls.charAt(i) == 'B'){
                index++;
            } else {
                count++;
            }
            if (index == blue){
                break;
            }
        }
        min = Math.min(min, count);

        // 파란색 공을 오른쪽으로
        index = 0;
        count = 0;
        for (int i = ballsLength - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B'){
                index++;
            } else {
                count++;
            }
            if (index == blue){
                break;
            }
        }
        min = Math.min(min, count);

        System.out.println(min);

    }
}
