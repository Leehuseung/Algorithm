package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 2164. Sort Even and Odd Indices Independently
 */
public class SortEvenandOddIndicesIndependently {
    public static int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> oddQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                evenQueue.add(nums[i]);
            } else {
                oddQueue.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                nums[i] = evenQueue.poll();
            } else {
                nums[i] = oddQueue.poll();
            }
        }

        return nums;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4,1,2,3}))); // 2,3,4,1
    }
}
