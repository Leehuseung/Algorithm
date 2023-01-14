package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Last Stone Weight
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() != 1){
            if(pq.size() == 0){
                return 0;
            }
            int one = pq.poll();
            int two = pq.poll();

            if(one == two){
                continue;
            } else {
                pq.add(one-two);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
//        System.out.println(lastStoneWeight(new int[]{1,3}));
        System.out.println(lastStoneWeight(new int[]{2,2}));
    }
}
