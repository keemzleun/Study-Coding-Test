package Programmers.글자이어붙여문자열만들기;

class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for (int i=0; i<index_list.length; i++) {
            int a = index_list[i];
            answer += my_string.charAt(a);
        }
        return answer;
    }
}