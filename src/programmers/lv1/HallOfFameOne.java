package programmers.lv1;

import java.util.*;

/**
 * Lv1. 명예의 전당 (1)
 */
public class HallOfFameOne {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            if(i >= score.length) break;
            pq.add(score[i]);
            answer[i] = pq.peek();
        }
        for (int i = k; i < score.length; i++) {
            if(pq.peek() < score[i]){
                pq.poll();
                pq.add(score[i]);
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}))); // [10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}))); //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
        System.out.println(Arrays.toString(solution(9, new int[]{10, 30, 40, 3, 0, 20, 4}))); //[10, 10, 10, 3, 0, 0, 0]
    }
}
