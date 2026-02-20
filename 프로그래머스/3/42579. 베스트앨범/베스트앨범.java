import java.util.*;

class Solution {
    class Music {
        int id, play;
        Music(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Music>> musicMap = new HashMap<>();
        
        for (int i=0; i<genres.length; i++){
            // 장르별 총합
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            
            // 노래 정보들
            musicMap.putIfAbsent(genres[i], new ArrayList<>());
            musicMap.get(genres[i]).add(new Music(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(totalMap.keySet());
        sortedGenres.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String g : sortedGenres){
            List<Music> list = musicMap.get(g);
            
            list.sort((a, b) -> {
                // 플레이수가 같으면 id 오름차순
                if (a.play == b.play) return a.id - b.id;
                // 플레이수로 내림차순
                return b.play - a.play;
            });
            
            result.add(list.get(0).id);
            if (list.size() > 1){
                result.add(list.get(1).id);
            }
        }
        
        
        
        return result.stream().mapToInt(i->i).toArray();
    }
}