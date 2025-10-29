import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    // 1. 102x102 맵 (좌표 2배 + 여유)
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    
    // 2. 상하좌우
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 3. 맵 그리기 (1단계: 테두리+내부 채우기)
        for (int[] rect : rectangle) {
            fillMap(rect[0] * 2, rect[1] * 2, rect[2] * 2, rect[3] * 2, 1);
        }

        // 4. 맵 그리기 (2단계: 내부 비우기)
        for (int[] rect : rectangle) {
            fillMap(rect[0] * 2 + 1, rect[1] * 2 + 1, rect[2] * 2 - 1, rect[3] * 2 - 1, 0);
        }

        // 5. BFS 실행
        int answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        // 6. 2배 확장된 거리였으므로 / 2
        return answer / 2;
    }

    // 맵 채우기/비우기 헬퍼
    private void fillMap(int x1, int y1, int x2, int y2, int value) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                map[y][x] = value;
            }
        }
    }

    // BFS (게임 맵과 거의 동일)
    private int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // x, y, distance
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 목표 도달
            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 경계 확인
                if (nx < 0 || nx > 101 || ny < 0 || ny > 101) {
                    continue;
                }

                // 길(1)이고, 방문 안 한 곳
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return 0; // 도달 불가 (문제 조건상 항상 도달)
    }
}