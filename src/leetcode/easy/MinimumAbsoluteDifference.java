package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 */
public class MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            min = Math.min(min ,arr[i+1] - arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int num = arr[j] - arr[i];
                if(num == min){
                    answer.add(Arrays.asList(arr[i], arr[j]));
                } else if(num > min){
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4,2,1,3}));
    }
}
