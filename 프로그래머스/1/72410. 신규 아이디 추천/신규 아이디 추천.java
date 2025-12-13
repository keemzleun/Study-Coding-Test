class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        answer = answer.toLowerCase();


        StringBuilder sb2 = new StringBuilder();
        for (char c : answer.toCharArray()) {
            if (isValidChar(c)) {
                sb2.append(c);
            }
        }
        answer = sb2.toString();


        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.isEmpty()) {
            answer = "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        if (answer.length() <= 2) {
            char lastChar = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += lastChar; 
            }
        }

        return answer;
    }
    
    private boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') || 
               (c >= '0' && c <= '9') || 
               c == '-' || c == '_' || c == '.';
    }
}