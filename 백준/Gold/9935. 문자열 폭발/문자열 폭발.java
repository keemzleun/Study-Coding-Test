import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭발
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String f = br.readLine();
        int fLength = f.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            
            if(stack.size() >= fLength) {
                boolean flag = true;

                for (int j = 0; j < fLength; j++) {
                    if (stack.get(stack.size() - fLength + j) != f.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    for (int j = 0; j < fLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : stack){
            sb.append(c);
        }

        System.out.println(sb.length()==0? "FRULA" : sb.toString());
        
    }
}
