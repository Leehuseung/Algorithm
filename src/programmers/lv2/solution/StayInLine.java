package programmers.lv2.solution;

import java.util.*;

/**
 * Lv2. 줄 서는 방법
 *
 * 22.08.05
 *
 * 22.08.17 정답코드까지 디버깅해서 도움받음
 *
 */
public class StayInLine {
    public static int[] solution(int n, long k) {
        int[] result = new int[n];
        long t = 1;
        for (int i = 1; i < n; i++) {
            t = t * i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        --k;
        while(n > 0){
            long r = k == 0 ? 0 : k/t;
            k = k == 0 ? 0 : k%t;
            result[result.length-n] = list.get((int) r);
            list.remove((int)r);
            --n;
            if(n != 0){
                t /= n;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,5))); //[3,1,2]
        System.out.println(Arrays.toString(solution(5,1))); //[1,2,3,4,5]
    }
}


