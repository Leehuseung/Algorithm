package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. Number of Arithmetic Triplets
 */
public class NumberofArithmeticTriplets {

    public static int arithmeticTriplets(int[] nums, int diff) {
        int answer = 0;

        for (int i = 1; i < nums.length-1; i++) {
            int middle = nums[i];

            int findNumMinus = middle - diff;
            int findNumPlus = middle + diff;

            boolean minus = false;
            boolean plus = false;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == findNumMinus){
                    minus = true;
                }
                if(nums[j] == findNumPlus){
                    plus = true;
                }
            }

            if(minus && plus) {
                answer++;
            }
        }

        return answer;
    }

    public static int best(int[] nums, int diff) {
        Set<Integer> seen = new HashSet<>();
        int cnt = 0;
        for(int num : nums) {
            seen.add(num);
            if(seen.contains(num-diff) && seen.contains(num-2*diff))
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        System.out.println(arithmeticTriplets(new int[]{0,1,4,6,7,10},3));
//        System.out.println(arithmeticTriplets(new int[]{4,5,6,7,8,9},2));
        System.out.println(best(new int[]{4,5,6,7,8,9},2));
    }
}
