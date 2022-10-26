package programmers.lv3.solution;

import java.util.Arrays;

/**
 * Lv3. 최고의 집합
 *
 * 22.09.19 슈도코드 참조
 */
public class BestSet {

    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        int el = s / n;
        if(el == 0) return new int[]{-1};
        for (int i = 0; i < n; i++) {
            answer[i] = el;
        }
        int m = s % n;
        int t = 0;
        for (int i = 0; i < m; i++) {
            answer[t++]++;
        }
        Arrays.sort(answer);
        return answer;
    }


    public static void main(String[] args) {
        solution(2,9);
        solution(2,8);
        solution(2,1);
        solution(4,18);
    }

}
