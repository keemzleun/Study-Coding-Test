import java.io.*;
import java.util.*;

// 가희와 키워드
public class Main {	
    public static void main(String[] args) throws Exception{		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        HashSet<String> hm = new HashSet<String>();
        for(int i=0;i<n;i++)
            hm.add(br.readLine());
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()) {
                String key=st.nextToken();
                if(hm.contains(key));
                    hm.remove(key);
            }
            sb.append(hm.size()+"\n");
        }
        System.out.println(sb.toString());
    }
}