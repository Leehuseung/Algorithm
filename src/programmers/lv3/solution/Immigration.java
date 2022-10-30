package programmers.lv3.solution;

import java.util.Arrays;

/**
 * Lv3. 입국심사
 *
 * 22.09.07
 *
 * 22.09.13 코드참고
 */
public class Immigration {

    public static long solution(long n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 0l;
        long right = times[times.length-1] * n;

        while(left <= right){
            long sum = 0l;
            long mid = (left + right)/2;
            for (int i = 0; i < times.length; i++) {
                sum += mid/times[i];
            }
            if(sum < n){
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{7,10}));
    }
}
