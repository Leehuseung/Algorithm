package leetcode.easy;

import java.util.Arrays;

/**
 * LeetCode Easy 2160. Minimum Sum of Four Digit Number After Splitting Digits
 */
public class MinimumSumofFourNumberAfterSplittingDigits {

    public static int minimumSum(int num) {
        String nums = num + "";
        int[] arr = new int[4];
        for (int i = 0; i < nums.length(); i++) {
            arr[i] = Integer.parseInt(nums.charAt(i) + "");
        }

        Arrays.sort(arr);

        return arr[0] * 10 + arr[2] + arr[1] * 10 + arr[3];
    }

    public static void main(String[] args) {
        /**
         * Input: num = 2932
         * Output: 52
         * Input: num = 4009
         * Output: 13
         */
        System.out.println(minimumSum(2932));
        System.out.println(minimumSum(4009));
    }
}
