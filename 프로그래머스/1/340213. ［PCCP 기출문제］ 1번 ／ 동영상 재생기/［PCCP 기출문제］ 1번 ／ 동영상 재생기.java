class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = toSec(video_len);
        int posSec = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        if (posSec >= opStartSec && posSec <= opEndSec){
            posSec = opEndSec;
        }
        
        for (String cmd : commands){
            if (cmd.equals("next")){
                posSec += 10;
                if (posSec > videoSec) posSec = videoSec;
            } else if (cmd.equals("prev")){
                posSec -= 10;
                if (posSec < 0) posSec = 0;
            }

            if (posSec >= opStartSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
        
        return String.format("%02d:%02d", posSec / 60, posSec % 60);
    }
    
    private int toSec(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}