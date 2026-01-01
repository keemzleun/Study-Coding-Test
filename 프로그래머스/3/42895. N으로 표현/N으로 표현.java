import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> countList = new ArrayList<>();
        for (int i = 0; i <= 8; i++){
            countList.add(new HashSet<>());
        }
        
        int temp = N;
        for (int i = 1; i <= 8; i++){
            countList.get(i).add(temp);
            temp = temp * 10 + N;
        }
        
        for(int i = 1; i <= 8; i++){
            for (int j = 1; j < i; j++){
                for (int val1 : countList.get(j)){
                    for (int val2 : countList.get(i-j)){
                        countList.get(i).add(val1 + val2);
                        countList.get(i).add(val1 - val2);
                        countList.get(i).add(val1 * val2);
                        if (val2 != 0) countList.get(i).add(val1/val2);
                    }
                }
            }

            if (countList.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}