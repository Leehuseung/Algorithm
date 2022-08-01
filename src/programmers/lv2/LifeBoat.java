package programmers.lv2;

import java.util.*;

/**
 * Lv2. 구명 보트
 */
public class LifeBoat {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = people.length-1; i >= 0 ; i--) {
            deque.add(people[i]);
        }

        while(!deque.isEmpty()) {
            answer++;

            if(deque.getFirst() + deque.getLast() <= limit){
                deque.pollLast();
            }
            deque.pollFirst();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution( new int[]{70,50,80,50}, 100));  //3
        System.out.println(solution( new int[]{70, 80, 50}, 100));      //3
        System.out.println(solution( new int[]{40,40,40}, 120));      //2
        System.out.println(solution( new int[]{40,50,150,160}, 200));    //2
        System.out.println(solution( new int[]{100,500,500,900,950}, 1000));    //3

    }
}
