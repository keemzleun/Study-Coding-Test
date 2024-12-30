import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 컨베이어 벨트 위의 로봇
public class Main {
    static int N, K;
    static int[] durability;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2 * N];
        robots = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;

        while (true) {
            step++;
            rotateBelt();
            moveRobots();
            placeRobot();
            if (countZeroDurability() >= K) {
                break;
            }
        }
        System.out.println(step);
    }

    // 벨트를 회전시키는 메서드
    static void rotateBelt() {
        // 내구도를 한 칸 회전
        int lastDurability = durability[2 * N -1];
        for (int i = 2 * N - 1; i > 0; i--) {
           durability[i] = durability[i - 1];
        }
        durability[0] = lastDurability;

        // 로봇 한 칸 회전
        for (int i = N - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = false;  // 올리는 위치에는 로봇이 없음
        robots[N - 1] = false;  // 내리는 위치에 있는 로봇은 내림
    }

    // 로봇을 이동시키는 메서드
    static void moveRobots() {
        for (int i = N - 1; i > 0; i--) {
            // i 위치에 로봇이 없는 경우 i-1 위치에 있는 로봇 이동
            if (robots[i - 1] && !robots[i] && durability[i] > 0) {
                robots[i] = true;
                robots[i - 1] = false;
                durability[i]--;
            }
        }
        robots[N - 1] = false;  // 내리는 위치에 있는 로봇 제거
    }

    // 로봇을 올리는 메서드
    static void placeRobot() {
        // 첫번째 위치의 내구도가 0 이상이면 로봇 올리기
        if (durability[0] > 0) {
            robots[0] = true;
            durability[0]--;
        }
    }

    // 내구도가 0인 칸의 개수를 세는 메서드
    static int countZeroDurability() {
        int count = 0;
        for (int d : durability) {
            if (d == 0) {
                count++;
            }
        }
        return count;
    }

}
