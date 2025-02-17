import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCnt = Integer.parseInt(br.readLine());    // 스위치 개수

        int[] switchs = new int[switchCnt+1];  // 스위치 상태
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1){
                for (int j = number; j <= switchCnt; j += number) {
                    switchs[j] = switchs[j] == 1 ? 0 : 1;
                }
            } else {
                int index = 0;
                while (number-(index + 1) > 0 && number + (index + 1) <= switchCnt
                        && switchs[number - (index+1)] == switchs[number + (index+1)]){
                    index++;
                }
                for (int j = number-index; j <= number+index; j++) {
                    switchs[j] = 1 - switchs[j];
                }
            }
        }

        for (int i = 1; i <= switchCnt; i++) {
            System.out.print(switchs[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
