package leetcode.easy;

import java.util.Arrays;

/**
 * 1725. Number Of Rectangles That Can Form The Largest Square
 */
public class NumberOfRectanglesThatCanFormTheLargestSquare {

    public static int countGoodRectangles(int[][] rectangles) {
        int answer = 0;

        int[] arr = new int[rectangles.length];

        for (int i = 0; i < rectangles.length; i++) {
            int min = Math.min(rectangles[i][0],rectangles[i][1]);
            arr[i] = min;
        }

        if(arr.length == 1){
            answer++;
        } else {
            Arrays.sort(arr);

            for (int i = arr.length-1; i >= 0 ; i--) {
                answer++;
                if(arr[i] != arr[i-1]){
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(countGoodRectangles(new int[][]{{5,8},{3,9},{5,12},{16,5}})); //3
//        System.out.println(countGoodRectangles(new int[][]{{2,3},{3,7},{4,3},{3,7}})); //3
        System.out.println(countGoodRectangles(new int[][]{{3,1}})); //
    }
}
