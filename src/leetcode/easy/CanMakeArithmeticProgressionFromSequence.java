package leetcode.easy;

import java.util.Arrays;

/**
 * 1502. Can Make Arithmetic Progression From Sequence
 */
public class CanMakeArithmeticProgressionFromSequence {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i+1]-arr[i] != arr[i+2] - arr[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3,5,1})); //t
//        System.out.println(canMakeArithmeticProgression(new int[]{1,2,4})); //f
    }
}
