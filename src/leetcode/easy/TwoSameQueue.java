package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lv2. 두 큐 합 같게 만들기
 */
public class TwoSameQueue {

    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> fQueue = new LinkedList<>();
        Queue<Integer> sQueue = new LinkedList<>();
        for (int i : queue1) {
            fQueue.add(i);
            sum1 += i;
        }
        for (int i : queue2) {
            sQueue.add(i);
            sum2 += i;
        }

        int answer = 0;
        while(!fQueue.isEmpty() && !sQueue.isEmpty()){
            if(sum1 > sum2){
                int poll = fQueue.poll();
                sQueue.add(poll);
                sum1 -= poll;
                sum2 += poll;
            } else if(sum1 < sum2){
                int poll = sQueue.poll();
                fQueue.add(poll);
                sum1 += poll;
                sum2 -= poll;
            } else {
                return answer;
            }
            answer++;
             if(answer > 600000)  return -1;

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,2,7,2}, new int[]{4,6,5,1}));
        System.out.println(solution(new int[]{1,2,1,2}, new int[]{1,10,1,2}));
        System.out.println(solution(new int[]{1,1}, new int[]{1,5}));

    }
}
