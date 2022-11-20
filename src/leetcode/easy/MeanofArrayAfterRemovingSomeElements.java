package leetcode.easy;

import java.util.Arrays;

/**
 * 1619. Mean of Array After Removing Some Elements
 */
public class MeanofArrayAfterRemovingSomeElements {

    public static double trimMean(int[] arr) {
        int n = arr.length;
        double sum = 0d;
        Arrays.sort(arr);
        for (int i = n / 20; i < n - n / 20; ++i) {
            sum += arr[i];
        }
        return sum / (n * 9 / 10);
    }

    public static void main(String[] args) {
        trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0});
    }
}
