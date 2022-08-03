package leetcode.easy;

import java.util.Arrays;

/**
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays
 */
public class MakeTwoArraysEqualbyReversingSubarrays {
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if(target[i] != arr[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3})); // true
    }
}
