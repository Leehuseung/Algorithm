package programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Lv2. 혼자 놀기의 달인
 */
public class MasterOfPlayingAlone {

    public static int solution(int[] cards) {
        boolean[] b = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            if(b[i]) continue;
            int ii = i;
            int cnt = 0;
            while(!b[ii]){
                b[ii] = true;
                int k = cards[ii];
                ii = k-1;
                cnt++;
            }
            pq.add(cnt);
        }

        return pq.poll() * (pq.isEmpty() ? 0 : pq.poll());
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,6,3,7,2,5,1,4})); // 12
        System.out.println(solution(new int[]{2,1})); // 2
    }
}
