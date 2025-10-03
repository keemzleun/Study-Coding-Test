// "."을 기준으로 년/월/일
// MM이 12를 넘을 경우, YYYY는 증가하고 MM은 1이 되어야 함
// privacy의 약관 종류 판단
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today, ".");
        int todayY = Integer.parseInt(st.nextToken());
        int todayM = Integer.parseInt(st.nextToken());
        int todayD = Integer.parseInt(st.nextToken());
        
        Map<String, Object> map = new HashMap<String, Object>();
        for(String t : terms){
            st = new StringTokenizer(t);
            String type = st.nextToken();
            int term = Integer.parseInt(st.nextToken());
            map.put(type, term);
        }
        
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            String type = st.nextToken();
            
            st = new StringTokenizer(date, ".");
            int YYYY = Integer.parseInt(st.nextToken());
            int MM = Integer.parseInt(st.nextToken());
            int DD = Integer.parseInt(st.nextToken());
            
            MM += (int) map.get(type); // num 대신 바로 계산
            // 1~12월 사이클을 맞추기 위해 1을 빼고 계산 후 다시 1을 더해줌
            YYYY += (MM - 1) / 12;
            MM = (MM - 1) % 12 + 1;
            
            if (todayY > YYYY) {
                answer.add(i+1);
            } else if (YYYY == todayY && todayM > MM){
                answer.add(i+1);
            } else if (YYYY == todayY && MM == todayM && todayD >= DD){
                answer.add(i+1);
            }
            
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}