package leetcode.easy;

import java.util.Arrays;

/**
 * 1313. Decompress Run-Length Encoded List
 */
public class DecompressRunLengthEncodedList {
    public static int[] decompressRLElist(int[] nums) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i+=2) {
            len += nums[i];
        }

        int[] answer = new int[len];

        for (int i = 0; i < nums.length; i+=2) {
            for (int j = 0; j < nums[i]; j++) {
                answer[index] = nums[i+1];
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(decompressRLElist(new int[] {1,2,3,4})));

//        System.out.println(decompressRLElist(new int[] {1,1,2,3}));

    }
}
