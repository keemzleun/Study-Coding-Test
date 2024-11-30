import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 영화감독 숌
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 0;
        while(count != N){
            if (String.valueOf(number).contains("666")){
                count++;
            }
            number++;
        }
        System.out.println(number - 1);
    }
}
