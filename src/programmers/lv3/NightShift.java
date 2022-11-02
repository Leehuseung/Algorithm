package programmers.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Lv3. 야근 지수
 */
public class NightShift {

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        while(n > 0){
            int num = pq.poll();
            if(num == 0){
                return 0;
            }
            pq.add(--num);
            n--;
        }

        long answer = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += (num * num);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4,3,3})); //12
        System.out.println(solution(1, new int[]{2,1,2})); //6
        System.out.println(solution(3, new int[]{1,1})); //0
    }
}
