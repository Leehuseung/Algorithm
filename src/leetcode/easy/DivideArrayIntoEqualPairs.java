package leetcode.easy;

import java.util.Arrays;

/**
 * 2206. Divide Array Into Equal Pairs
 */
public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i += 2) {
            if(nums[i] != nums[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3,2,3,2,2,2})); // true
        System.out.println(divideArray(new int[]{1,2,3,4})); // false
    }
}
