package programmers.lv1;

import java.util.*;

/**
 * Lv1. 달리기 경주
 */
public class RunningRace {

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) map.put(players[i], i);
        for (int i = 0; i < callings.length; i++) {
            int kk = map.get(callings[i]);
            String a = players[kk];
            String b = players[kk-1];
            players[kk] = b;
            players[kk-1] = a;
            map.put(a, kk-1);
            map.put(b, kk);
        }
        return players;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(
                        new String[]{"mumu", "soe", "poe", "kai", "mine"},
                        new String[]{"kai", "kai", "mine", "mine"}
                )
        )); // "mumu", "kai", "mine", "soe", "poe"
    }
}
