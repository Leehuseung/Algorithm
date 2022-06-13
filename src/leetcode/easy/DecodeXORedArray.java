package leetcode.easy;

import java.util.Arrays;

/**
 * LeetCode Decode XOR Red Array
 */
public class DecodeXORedArray {
    public static int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length+1];
        answer[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            answer[i+1] = answer[i] ^ encoded[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1,2,3},1)));
        System.out.println(Arrays.toString(decode(new int[]{6,2,7,3},4)));
//        System.out.println(2 ^ 3);
        System.out.println(1^0);
    }
}
