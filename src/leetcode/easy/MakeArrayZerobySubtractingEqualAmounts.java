package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2357. Make Array Zero by Subtracting Equal Amounts
 */
public class MakeArrayZerobySubtractingEqualAmounts {

    public static int minimumOperations(int[] nums) {
        int answer = 0;
        while(!isAllZero(nums)){
            int min = minimum(nums);
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    nums[i] = nums[i] - min;
                }
            }
            answer++;
        }
        return answer;
    }

    public static int minimum(int[] nums){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                min = Math.min(min,nums[i]);
            }
        }
        return min;
    }

    public static boolean isAllZero(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                return false;
            }
        }
        return true;
    }

    //best
    public int best_minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++)
        {
            if(nums[i] != 0)
            {
                set.add(nums[i]);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,5,0,3,5})); // 3
        System.out.println(minimumOperations(new int[]{0}));         // 0
    }
}
