// 자연수 N을 연속된 자연수로 표현하는 방법은 N의 약수 중 홀수의 개수와 같음
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if (n % i == 0 && i % 2 == 1){
                answer++;
            }
        }       
        return answer;
    }
}