package leetcode.easy;

import java.util.Arrays;

public class BuildArrayfromPermutation {

    public static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length ; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }

    public static void main(String[] args) {
        /*
            Input: nums = [0,2,1,5,3,4]
            Output: [0,1,2,4,5,3]
            Input: nums = [5,0,1,2,3,4]
            Output: [4,5,0,1,2,3]
         */

        System.out.println(Arrays.toString(buildArray(new int[]{0,2,1,5,3,4})));
        System.out.println("----");
        System.out.println(Arrays.toString(buildArray(new int[]{5,0,1,2,3,4})));
    }
}
