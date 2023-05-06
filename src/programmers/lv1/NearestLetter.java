package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Lv1. 가장 가까운 글자
 */
public class NearestLetter {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> map = new HashMap<>();
        String[] ss = s.split("");
        for (int i = 0; i < ss.length; i++) {
            String sss = ss[i];
            if(map.containsKey(sss)){
                answer[i] = i - map.get(sss);
            } else {
                answer[i] = -1;
            }
            map.put(sss, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana"))); //[-1, -1, -1, 2, 2, 2]
        System.out.println(Arrays.toString(solution("foobar"))); //[-1, -1, 1, -1, -1, -1]
    }
}
