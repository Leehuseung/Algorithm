package programmers.lv2;

import java.util.*;

/*
 * Lv2. 프린터
 */
public class Printer {

    static class Task {
        int loc;
        int priority;

        public Task(int loc, int priority) {
            this.loc = loc;
            this.priority = priority;
        }

        public int getLoc() {
            return loc;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriority = 0;

        LinkedList<Task> list = new LinkedList();
        //list 생성
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Task(i,priorities[i]));
        }

        maxPriority = getMaxPriority(list);

        while(!list.isEmpty()){
            int head = list.getFirst().getPriority();
            if(head == maxPriority){
                answer++;
                if(location == list.getFirst().getLoc()){
                    return answer;
                }
                list.removeFirst();
                maxPriority = getMaxPriority(list);

            } else {
                list.addLast(list.getFirst());
                list.removeFirst();
            }
        }
        return -1;
    }

    public static int getMaxPriority(LinkedList<Task> list) {
        int maxPriority = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPriority() > maxPriority){
                maxPriority = list.get(i).getPriority();
            }
        }
        return maxPriority;
    }

    /*
         PriorityQueue를 이용한 방법
    */
    public int priorityQueueSolution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> prior = new PriorityQueue<>(Collections.reverseOrder());

        for(int number:priorities){
            prior.offer(number);
        }

        while(!prior.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(prior.peek() == priorities[i]){
                    prior.poll();
                    answer++;

                    if(location == i){
                        prior.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,3,2}, 2));
        System.out.println(solution(new int[]{1,1,9,1,1,1}, 0));
    }
}

