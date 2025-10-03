import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        int date = getDate(today);
        
        Map<String, Object> map = new HashMap<String, Object>();
        for (String t : terms){
            String[] term = t.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for (int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            
            int num = getDate(privacy[0]);
            int type = (int)map.get(privacy[1]);
            
            num += type * 28;
            if (date >= num) answer.add(i+1);      
        }
        return answer.stream().mapToInt(integer->integer).toArray();
    }
    public int getDate(String today){
        String[] dates = today.split("\\.");
        int yyyy = Integer.parseInt(dates[0]);
        int mm = Integer.parseInt(dates[1]);
        int dd = Integer.parseInt(dates[2]);
        return (yyyy * 12 * 28) + (mm * 28) + dd;
    }
}