
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 숫자고르기
public class Main {
    static int[] arr;
    static ArrayList<Integer> list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        visit = new boolean[N + 1];
        for (int i = 1; i < N+1; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
        
    }
    static void dfs(int index, int start){
        if (arr[index] == start){
            list.add(start);
        }
        if (!visit[arr[index]]){
            visit[arr[index]] = true;
            dfs(arr[index], start);
            visit[arr[index]] = false;
        }
    }

}
