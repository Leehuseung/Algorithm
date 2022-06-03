package leetcode.easy;

import java.util.Arrays;
/*
 * LeetCode Easy
 */
public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] answer = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = matrix[j][i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}})));
//        System.out.println(Arrays.toString(transpose(new int[][] {{1,2,3},{4,5,6}})));
    }
}
