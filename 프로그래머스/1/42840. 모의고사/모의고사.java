import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < answers.length; i++){
            if (first[i % first.length] == answers[i]) count1++;
            if (second[i % second.length] == answers[i]) count2++;
            if (third[i % third.length] == answers[i]) count3++;
        }
        
        int max = Math.max(count1, Math.max(count2, count3));
        List<Integer> temp = new ArrayList<>();
        if (count1 == max) temp.add(1);
        if (count2 == max) temp.add(2);
        if (count3 == max) temp.add(3);
        
        int[] answer = temp.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}