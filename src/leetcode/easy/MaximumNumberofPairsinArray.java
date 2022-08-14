package leetcode.easy;

import java.util.Arrays;

/**
 * 2341. 기
 */
public class MaximumNumberofPairsinArray {

    public static int[] numberOfPairs(int[] nums) {
        int[] answer = new int[2];
        int[] newNums = null;
        int cnt = 0;

        while(isDuplicate(nums)){
            cnt++;
            int[] duplicateArr = getDuplicateIndex(nums);
            newNums = new int[nums.length-2];
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i != duplicateArr[0] && i != duplicateArr[1]){
                    newNums[k++] = nums[i];
                }
            }
            nums = newNums;
        }

        answer[0] = cnt;
        answer[1] = nums.length;
       return answer;
    }

    private static boolean isDuplicate(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if(answer[i] == answer[j]){
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] getDuplicateIndex(int[] answer) {
        int[] duplicateArr = new int[2];
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if(answer[i] == answer[j]){
                    duplicateArr[0] = i;
                    duplicateArr[1] = j;
                    return duplicateArr;
                }
            }
        }
        return duplicateArr;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1,3,2,1,3,2,2}))); // [3,1]
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1,1}))); //[1,0]
        System.out.println(Arrays.toString((numberOfPairs(new int[]{0}))));   //[0,1]
    }
}
