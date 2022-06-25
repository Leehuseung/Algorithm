package leetcode.easy;

/**
 * LeetCode 2176. Count Equal and Divisible Pairs in an Array
 */
public class CountEqualandDivisiblePairsinanArray {

    public static int countPairs(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i] == nums[j])){
                    int l = i * j;
                    if(l % k == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3,1,2,2,2,1,3},2)); //4
        System.out.println(countPairs(new int[]{1,2,3,4},1)); //0
    }
}
