package leetcode.easy;

import java.util.Arrays;

/**
 * 561. Array Partition
 */
public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) answer += nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));     // 4
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2})); // 9
    }
}
