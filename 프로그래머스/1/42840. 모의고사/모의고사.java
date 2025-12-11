import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0; 
        int score2 = 0; 
        int score3 = 0;
        
        for (int i=0; i < answers.length; i++){
            if (first[i % first.length] == answers[i]) score1++;
            if (second[i % second.length] == answers[i]) score2++;
            if (third[i % third.length] == answers[i]) score3++;
        }
        int maxScore = Math.max(score1, Math.max(score2, score3));
        
        List<Integer> topScorers = new ArrayList<>();
        
        if (score1 == maxScore) {
            topScorers.add(1);
        }
        if (score2 == maxScore) {
            topScorers.add(2);
        }
        if (score3 == maxScore) {
            topScorers.add(3);
        }
        
        int[] answer = new int[topScorers.size()];
        for (int i = 0; i < topScorers.size(); i++) {
            answer[i] = topScorers.get(i);
        }
        
        return answer;
    }
}