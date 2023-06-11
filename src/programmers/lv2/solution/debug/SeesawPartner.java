package programmers.lv2.solution.debug;

import java.util.*;

/**
 * Lv2. 시소 짝꿍
 *
 * 23.06.06
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
public class SeesawPartner {
    public static long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long count = 0;
        for (int w : weights) {
            if (map.containsKey(1.0 * w)) {
                count += map.get(1.0 * w);
            }
            if (map.containsKey((1.0 / 2) * w)) {
                count += map.get((1.0 / 2) * w);
            }
            if (map.containsKey((2.0 / 3) * w)) {
                count += map.get((2.0 / 3) * w);
            }
            if (map.containsKey((3.0 / 4) * w)) {
                count += map.get((3.0 / 4) * w);
            }
            map.put(1.0 * w, map.getOrDefault(1.0 * w, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 180, 360, 100, 270})); //4
    }
}
