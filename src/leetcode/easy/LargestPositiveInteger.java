package leetcode.easy;

import java.util.Arrays;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 */
public class LargestPositiveInteger {

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0 ; i--) {
            int k = nums[i];
            if(k == 0) break;
            for (int j = 0; j < nums.length; j++) {
                if(k == -(nums[j])) return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
