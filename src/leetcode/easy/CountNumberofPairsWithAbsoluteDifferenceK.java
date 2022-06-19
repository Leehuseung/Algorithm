package leetcode.easy;

/**
 * LeetCode 2006. Count Number of Pairs With Absolute Difference K
 */
public class CountNumberofPairsWithAbsoluteDifferenceK {

    public static int countKDifference(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1,2,2,1},1));//4
        System.out.println(countKDifference(new int[]{1,3},3));//0
        System.out.println(countKDifference(new int[]{3,2,1,5,4},2));//3
    }
}
