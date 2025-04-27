import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]);
            
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b.plays - a.plays); // 재생 수 기준 내림차순
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Song {
    int index;
    int plays;
    
    Song(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }
}
