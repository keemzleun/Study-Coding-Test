import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        
        for (int c : citations){
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        
        int total = citations.length;
        int papers = 0;
        int hIndex = 0;
        
        for (int h = total; h >= 0; h--){
            papers = 0;
            for (int count : hmap.tailMap(h).values()){
                papers += count;
            }
            
            if (papers >= h){
                hIndex = h;
                break;
            }
        }
        
        
        return hIndex;
    }
}