package programmers.lv2;

import java.util.*;

/**
 * Lv2. 연속 부분 수열 합의 개수
 */
public class SumConsecutiveSubsequences {

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int t = 1;
                int total = elements[j];
                while(t <= cnt){
                    int kkk = j + t;
                    if(kkk >= elements.length) {
                        kkk -= elements.length;
                    }
                    total += elements[kkk];
                    t++;
                }
                set.add(total);
            }
            cnt++;
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 7,9,1,1,4 }));
    }
}
