package leetcode.easy;

import java.util.Arrays;

/**
 * LeetCode 1913. Maximum Product Difference Between Two Pairs
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1] * nums[nums.length-2]) - (nums[0] * nums[1]);
    }

    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5,6,2,7,4})); //23
        System.out.println(maxProductDifference(new int[]{4,2,5,9,7,4,8})); //64
    }
}
