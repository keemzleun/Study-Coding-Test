// lost: 도난당한 학생수
// reserve: 여벌 체육복수
// answer: 수업을 들을 수 있는 최대 학생수

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        
        // 체육복 개수 
        // 모든 학생이 체육복을 1개씩 가지고 있다고 초기화
        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }

        // 여벌 체육복이 있는 학생의 상태를 +1
        for (int r : reserve) {
            students[r]++;
        }

        // 도난당한 학생의 상태를 -1
        for (int l : lost) {
            students[l]--;
        }
        
        // 체육복 빌려주기
        // 최대한 앞의 학생에게 빌려주도록 하기
        for(int i = 1; i <= n; i++){
            if (students[i] == 0){
                if (i > 1 && students[i-1] == 2){
                    students[i]++;
                    students[i-1]--;
                } else if (i < n && students[i+1] == 2){
                    students[i]++;
                    students[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i<=n; i++){
            if (students[i] > 0){
                answer++;
            }
        }
        
        return answer;
    }
}