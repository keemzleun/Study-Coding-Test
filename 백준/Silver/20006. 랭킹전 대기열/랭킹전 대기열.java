import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 랭킹전 대기열
public class Main {
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        // 이름 사전순 정렬
        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();

            if (!players[i].check) {
                for (int j = i; j < p; j++) {
                    if (room.size() == m) {
                        break;
                    }

                    int level = players[j].level;
                    String name = players[j].name;

                    if (!players[j].check && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].check = true;
                        room.add(new Player(level, name));
                    }
                }
                Collections.sort(room);

                if (room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for (Player player : room) {
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
