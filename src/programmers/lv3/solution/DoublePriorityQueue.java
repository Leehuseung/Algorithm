package programmers.lv3.solution;

import java.util.*;

/**
 * lv3. 이중 우선순위 큐
 *
 * 슈도코드 참조
 */
public class DoublePriorityQueue {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reversePq = new PriorityQueue<>((o1, o2) -> o1 >= o2 ? -1 : 1);

        for (int i = 0; i < operations.length; i++) {
            String command = operations[i];
            if(command.startsWith("I")){
                String[] arr = command.split(" ");
                int num = Integer.parseInt(arr[1]);
                pq.add(num);
                reversePq.add(num);
            } else if(command.equals("D 1") && pq.size() > 0){
                int num = reversePq.poll();
                pq.remove(num);
            } else if(command.equals("D -1") && pq.size() > 0){
                int num = pq.poll();
                reversePq.remove(num);
            }
        }

        int[] answer = new int[2];
        if(pq.size() != 0){
            answer[0] = reversePq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // [0,0]
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // [333,-45]
    }
}