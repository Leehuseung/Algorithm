package programmers.lv3.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Lv3. 숫자 게임
 *
 * 슈도코드 참고..
 */
public class NumberGame {
    public static int solution(int[] A, int[] B) {
        PriorityQueue<Integer> apq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bpq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : A) {
            apq.add(i);
        }
        for (int i : B) {
            bpq.add(i);
        }

        int answer = 0;
        while(!apq.isEmpty()){
            if(bpq.peek() > apq.peek()){
                answer++;
                bpq.poll();
                apq.poll();
            } else {
                apq.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
    }
}
