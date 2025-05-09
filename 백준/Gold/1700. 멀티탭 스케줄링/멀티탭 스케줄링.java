import java.io.*;
import java.util.*;

// 멀티탭 스케줄링
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[K]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[K+1];
        int put = 0;
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int temp = order[i];

            if (!use[temp]) {
                if (put < N) {
                    use[temp] = true;
                    put++;
                } else {
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (use[order[j]] && !arrList.contains(order[j])) {
                            arrList.add(order[j]);
                        }
                    }

                    if (arrList.size() != N) {
                        for (int j = 0; j < use.length; j++) {
                            if (use[j] && !arrList.contains(j)) {
                                use[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = arrList.get(arrList.size() - 1);
                        use[remove] = false;
                    }

                    use[temp] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
