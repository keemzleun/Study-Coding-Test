import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        // 1. 오늘 날짜를 총 일수로 변환
        int todayTotalDays = getTotalDays(today);
        
        // 2. 약관 정보를 맵에 저장
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] s = t.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]) * 28); // 개월수를 일수로 변환
        }
        
        // 3. 개인정보 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int privacyDays = getTotalDays(p[0]);
            int duration = termMap.get(p[1]);
            
            // 수집일 + 유지기간 <= 오늘날짜 이면 파기
            if (privacyDays + duration <= todayTotalDays) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(x -> x).toArray();
    }
    
    private int getTotalDays(String date) {
        String[] s = date.split("\\."); // 마침표 주의!
        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        return (y * 12 * 28) + (m * 28) + d;
    }
}