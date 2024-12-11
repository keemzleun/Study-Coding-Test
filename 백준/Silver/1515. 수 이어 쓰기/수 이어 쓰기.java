import java.io.*;

// 수 이어 쓰기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int pointer = 0;
        int base = 0;

        while (base++ <= 30000) {
            String temp = String.valueOf(base);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == input.charAt(pointer)) {
                    pointer++;
                }

                if (pointer == input.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
