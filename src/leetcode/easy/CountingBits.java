package leetcode.easy;

import java.util.Arrays;

/**
 * 338. Counting Bits
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            answer[i] = Integer.bitCount(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5))); // [0,1,1,2,1,2]
    }
}
