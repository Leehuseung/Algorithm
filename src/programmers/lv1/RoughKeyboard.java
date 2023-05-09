package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Lv1. 대충 만든 자판
 */
public class RoughKeyboard {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String[] ss = keymap[i].split("");
            for (int j = 0; j < ss.length; j++) {
                if(map.containsKey(ss[j]) && map.get(ss[j]) > j+1){
                    map.put(ss[j],j+1);
                } else if(!map.containsKey(ss[j])) {
                    map.put(ss[j],j+1);
                }
            }
        }
        a:
        for (int i = 0; i < targets.length; i++) {
            String[] ss = targets[i].split(""); // A , C
            for (int j = 0; j < ss.length; j++) {
                if(map.containsKey(ss[j])){   //B, C
                    answer[i] += map.get(ss[j]);
                } else {
                    answer[i] = -1;
                    continue a;
                }
            }
            if(answer[i] == 0) answer[i] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"ABACD", "BCEFD"},
                new String[]{"ABCD","AABB"}
        ))); // 9,4
        System.out.println(Arrays.toString(solution(
                new String[]{"AA"},
                new String[]{"B"}
        ))); // -1
        System.out.println(Arrays.toString(solution(
                new String[]{"AGZ", "BSSS"},
                new String[]{"ASA","BGZ"}
        ))); // 4, 6
          System.out.println(Arrays.toString(solution(
                new String[]{"BC"},
                new String[]{"AC","BC"}
          ))); // -1, 3
    }
}
