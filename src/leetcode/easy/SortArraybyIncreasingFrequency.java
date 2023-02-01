package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1636. Sort Array by Increasing Frequency
 */
public class SortArraybyIncreasingFrequency {

    public static int[] frequencySort(int[] nums) {
        Integer[] answer = new Integer[nums.length];
        int[] table = new int[202];
        for (int num : nums) {
            table[num+100] += 1;
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i];
        }

        Arrays.sort(answer, (Comparator<Object>) (o1, o2) -> {
            Integer o11 = (Integer) o1+100;
            Integer o21 = (Integer) o2+100;
            if(table[o11]-table[o21] > 0){
                return 1;
            } else if(table[o11]-table[o21] < 0){
                return -1;
            } else {
                if(o11 - o21 > 0){
                    return -1;
                } else if(o11 - o21 < 0){
                    return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = answer[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1,1,2,2,2,3})));
    }


}