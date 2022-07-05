package leetcode.easy;

/**
 * LeetCode 1827. Minimum Operations to Make the Array Increasing
 */
public class MinimumOperationstoMaketheArrayIncreasing {
    public static int minOperations(int[] nums) {
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            while(nums[i-1] >= nums[i]){
                nums[i] = nums[i] + 1;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,1})); // 3
        System.out.println(minOperations(new int[]{1,5,2,4,1})); // 14
        System.out.println(minOperations(new int[]{8})); // 0
    }
}
