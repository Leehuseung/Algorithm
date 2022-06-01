package leetcode.easy;

import java.util.Arrays;

public class RunningSumof1dArray {

    public static int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            arr[i] = total;
        }

        return arr;
    }

    public static void main(String[] args) {
        /*
            Input: nums = [1,2,3,4]
            Output: [1,3,6,10]
            Input: nums = [1,1,1,1,1]
            Output: [1,2,3,4,5]
         */

        System.out.println(Arrays.toString(runningSum(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));


    }
}
