package programmers.lv2.solution;

import java.util.Arrays;

/**
 * Lv2.숫자 블록
 *
 * 22.08.28
 *
 * 22.08.29
 */
public class NumberBlock {
    public static int[] solution(long begin, long end) {
        int n = (int)(end-begin)+1;
        int[] answer = new int[n];
        int k = 0;
        for (long i = begin; i <= end; i++) {
            if(i == 1l){
                k++;
                continue;
            }
            long num = (long)Math.sqrt(i);
            for (long j = 2; j <= num; j++) {
                long left = i % j;
                if(left == 0 && (i/j) <= 10000000){
                    answer[k] = (int) (i / j);
                    break;
                }
            }
            if(answer[k] == 0){
               answer[k] = 1;
            }
            k++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1,10))); // [0,1,1,2,1,3,1,4,3,5]
        System.out.println(Arrays.toString(solution(6,10)));
    }
}
