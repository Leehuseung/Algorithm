package programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Lv2. 디펜스 게임
 */
public class DefenseGame {
    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            int en = enemy[i];
            pq.add(en);
            if(n >= en){
                n -= en;
                answer++;
            } else {
                if(k > 0){
                    answer++;
                    int p = pq.poll();
                    k--;
                    n += p;
                    n -= en;
                } else {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(7,3,new int[]{4,2,4,5,3,3,1})); // 5
    }
}
