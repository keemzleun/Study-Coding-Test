import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // 1. {현재 단어, 변환 단계}를 저장할 내부 클래스
    class State {
        String word;
        int steps;

        State(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int solution(String begin, String target, String[] words) {
        
        // 5. 예외 처리: words에 target이 없으면 변환 불가
        boolean targetExists = false;
        for (String w : words) {
            if (w.equals(target)) {
                targetExists = true;
                break;
            }
        }
        if (!targetExists) {
            return 0;
        }

        // 2. Queue 생성
        Queue<State> queue = new LinkedList<>();
        
        // 3. visited 배열 (words 배열 기준)
        boolean[] visited = new boolean[words.length];

        // 6. BFS 시작점 설정
        queue.add(new State(begin, 0));

        // 6. 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 6-2. 목표 도달 확인
            if (current.word.equals(target)) {
                return current.steps;
            }

            // 6-3. words 배열을 순회하며 '간선(Edge)' 찾기
            for (int i = 0; i < words.length; i++) {
                
                // 6-4. 방문 안 했고, 한 글자만 다른 단어 찾기
                if (!visited[i] && isOneLetterDifferent(current.word, words[i])) {
                    
                    // 6-5. 방문 처리 및 큐에 추가
                    visited[i] = true;
                    queue.add(new State(words[i], current.steps + 1));
                }
            }
        }

        // 7. 탐색 실패
        return 0;
    }

    // 4. 두 단어가 한 글자만 다른지 확인하는 헬퍼 함수
    private boolean isOneLetterDifferent(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
            // 최적화: 2개 이상 다르면 바로 false 반환
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
}