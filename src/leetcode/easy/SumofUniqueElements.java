package leetcode.easy;

import java.util.Arrays;

/**
 * 1748. 스
 */
public class SumofUniqueElements {
    public static int sumOfUnique(int[] nums) {
        int answer = 0;
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i != nums.length-1 && nums[i] == nums[i+1]){
                continue;
            }
            if(i == nums.length-1 && nums[i] == nums[i-1]){
                continue;
            }
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            answer += nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));   //4
        System.out.println(sumOfUnique(new int[]{1,1,1,1,1})); //0
        System.out.println(sumOfUnique(new int[]{1,2,3,4,5})); //15
        System.out.println(sumOfUnique(new int[]{10})); // 10
        System.out.println(sumOfUnique(new int[]{10,6,9,6,9,6,8,7})); // 25
    }
}
