import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for (String gem : gems){
            set.add(gem);
        }
        int total = set.size();
        
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>(); // 보석과 그 개수를 저장할 Map
        int start = 0;
        int min = Integer.MAX_VALUE;
        
        for(int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.size() == total){
                if (end - start < min){
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
            
                String startGem = gems[start];
                map.put(startGem, map.get(startGem) - 1);

                if (map.get(startGem) == 0){
                    map.remove(startGem);
                }
                start++;
            }
        }
        return answer;

    }
}