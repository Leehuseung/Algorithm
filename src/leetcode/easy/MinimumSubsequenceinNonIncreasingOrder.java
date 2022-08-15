package leetcode.easy;

import java.util.*;

/**
 * 1403. Minimum Subsequence in Non-Increasing Order
 */
public class MinimumSubsequenceinNonIncreasingOrder {
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int subTotal = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            int num = nums[i];
            subTotal += num;
            total -= num;
            list.add(num);
            if(subTotal > total){
                return list;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{4,3,10,9,8})); // [10,9]
        System.out.println(minSubsequence(new int[]{4,4,7,6,7})); // [7,7,6]
        System.out.println(minSubsequence(new int[]{6})); // [6]
    }
}
