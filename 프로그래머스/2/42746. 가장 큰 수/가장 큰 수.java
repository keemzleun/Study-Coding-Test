import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {String answer = "";
        String[] stringNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 내림차순 정렬: (a + b) vs (b + a)
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if (stringNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", stringNumbers);
    }
}