package leetcode.easy;

/**
 * LeetCode Easy 1512. Number of Good Pairs
 */
public class NumberofGoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] ){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        /**
         * Input: nums = [1,2,3,1,1,3]
         * Output: 4
         * Input: nums = [1,1,1,1]
         * Output: 6
         * Input: nums = [1,2,3]
         * Output: 0
         */
        System.out.println(numIdenticalPairs(new int[] {1,2,3,1,1,3}));
        System.out.println(numIdenticalPairs(new int[] {1,1,1,1}));
        System.out.println(numIdenticalPairs(new int[] {1,2,3}));


    }
}
