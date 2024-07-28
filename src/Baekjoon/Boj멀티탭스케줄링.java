package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj멀티탭스케줄링 {
    // 그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 멀티탭 구멍의 개수
        int K = Integer.parseInt(st.nextToken());   // 전기 용품 사용 횟수

        int[] order = new int[K];                   // 사용 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[K+1];       // 사용했는지 안 했는지 판별
        int put = 0;    // 사용하고 있는 멀티탭 구멍의 개수 (<= N)
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int temp = order[i];

            if (!use[temp]) { // 콘센트가 꽂혀있지 않은 경우
                if (put < N) { // 콘센트를 꽂을 공간이 있는 경우
                    use[temp] = true;
                    put++;
                } else { // 콘센트를 꽂을 공간이 없는 경우

                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (use[order[j]] && !arrList.contains(order[j])) { // 해당 전기용품이 멀티탭에 꽂혀있는지 & arrList에 포함되어 있지 않으면 추가
                            arrList.add(order[j]);
                        }
                    }

                    if (arrList.size() != N) { // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우.
                        for (int j = 0; j < use.length; j++) {
                            if (use[j] && !arrList.contains(j)) { // 사용하고 있는 콘센트 중 나중에 사용하지 않으면 멀티탭에서 제거
                                use[j] = false;
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1); // 가장 마지막에 사용될 콘센트를 제거.
                        use[remove] = false;
                    }

                    use[temp] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans + "\n");
        br.close();
    }
}
