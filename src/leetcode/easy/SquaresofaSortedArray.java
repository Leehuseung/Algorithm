package leetcode.easy;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 */
public class SquaresofaSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i] * nums[i];
        }
        Arrays.sort(answer);
        return answer;
    }

    //best
    public static int[] best(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(best(new int[]{-4,-1,0,3,10}))); //[0,1,9,16,100]
//        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11}))); //[4,9,9,49,121]
    }
}
