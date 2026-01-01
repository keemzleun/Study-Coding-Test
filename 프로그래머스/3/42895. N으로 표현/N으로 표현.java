import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i <= 8; i++){
            list.add(new HashSet<>());
        }
        
        int temp = N;
        for (int i=1; i<=8; i++){
            list.get(i).add(temp);
            temp = temp * 10 + N;
        }
        
        for (int i = 1; i <= 8; i++){
            for (int j = 1; j < i; j++){
                for (int val1 : list.get(j)){
                    for (int val2 : list.get(i-j)){
                        list.get(i).add(val1 + val2);
                        list.get(i).add(val1 - val2);
                        list.get(i).add(val1 * val2);
                        if (val2 != 0){
                            list.get(i).add(val1 / val2);
                        }
                    }
                }
            }
            if (list.get(i).contains(number)){
                return i;
            }
        }
        
        
        return -1;
    }
}