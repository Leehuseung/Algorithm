package programmers.lv2;

import java.util.Arrays;

/**
 * Lv2. 최솟값 만들기
 */
public class MakeAMIN {

    public static int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++)  answer += A[i] * B[B.length-1-i];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,4,2}, new int[]{5,4,4}));// 29
        System.out.println(solution(new int[]{1,2}, new int[]{3,4}));// 10
    }
}
