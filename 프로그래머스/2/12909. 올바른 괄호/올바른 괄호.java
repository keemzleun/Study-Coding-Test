import java.util.Stack;
class Solution {
    public boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop(); 
            }
        }

        return stack.isEmpty();
    }
    
}