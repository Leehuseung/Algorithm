package leetcode.easy;

import java.util.Arrays;

/**
 * 1464. Maximum Product of Two Elements in an Array
 */
public class MaximumProductofTwoElementsinanArray {
    public static int maxProduct(int[] nums) {
        int len = nums.length-1;
        Arrays.sort(nums);
        return (nums[len]-1) * ((nums[len-1]-1));
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2})); // 12
        System.out.println(maxProduct(new int[]{1,5,4,5})); // 16
        System.out.println(maxProduct(new int[]{3,7})); // 12
    }
}
