class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int dis = w * 2 + 1;
        for (int s : stations){
            int left = s - w;
            if (left > now){
                answer += (left - now) / dis;
                if ((left - now) % dis != 0) answer++;
            }
            now = s + w + 1;
        }

        if (n >= now){
            answer += (n - now + 1) / dis;
            if ((n - now + 1) % dis != 0) answer++;
        }
        return answer;
    }
}