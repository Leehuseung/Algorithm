package leetcode.easy;

import java.util.Arrays;

/**
 * 1051. Height Checker
 */
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int answer=0;
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]){
                ++answer;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3})); // 3
        System.out.println(heightChecker(new int[]{5,1,2,3,4})); // 5
        System.out.println(heightChecker(new int[]{1,2,3,4,5})); // 0
    }
}
