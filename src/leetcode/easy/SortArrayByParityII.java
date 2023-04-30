package leetcode.easy;

import java.util.Arrays;

/**
 * 922. Sort Array By Parity II
 */
public class SortArrayByParityII {

    public static int[] sortArrayByParityII(int[] nums) {
        int[] answer = new int[nums.length];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                answer[even] = nums[i];
                even += 2;
            } else {
                answer[odd] = nums[i];
                odd += 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }
}
