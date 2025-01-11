import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u'};

        while(true){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("end")) break;
            else {
                boolean acceptable = true;
                boolean hasVowel = false;
                int cntVowel = 0;
                int cntConsonant = 0;
                for(int i = 0; i < input.length(); i++){
                    char cur = input.charAt(i);
                    boolean isVoewl = false;
                    for(int j = 0; j < vowels.length; j++){
                        if(cur == vowels[j]){
                            isVoewl = true;
                            hasVowel = true;
                            cntVowel++;
                            cntConsonant = 0;
                            break;
                        }
                    }
                    if(!isVoewl) {
                        cntConsonant++;
                        cntVowel = 0;
                    }
                    if(i == input.length()-1){
                        if(!hasVowel) {
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                    }
                    if(i >= 1){
                        if(cur == input.charAt(i-1) && cur != 'e' && cur != 'o'){
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                        else if(cntVowel >= 3 || cntConsonant >= 3){
                            System.out.println("<" + input + "> is not acceptable.");
                            acceptable = false;
                            break;
                        }
                    }
                }
                if(acceptable) System.out.println("<" + input + "> is acceptable.");
            }
        }
    }
}