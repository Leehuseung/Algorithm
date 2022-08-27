package leetcode.easy;

import java.util.Arrays;

/**
 * 1030. Matrix Cells in Distance Order
 *
 * O(n^2)으로 O(n)풀이 를 하도록 생각해볼것.
 */
public class MatrixCellsinDistanceOrder {
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix = new int[rows][cols];
        int[][] answer = new int[rows * cols][];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                answer[k++] = new int[]{i,j};
            }
        }

        Arrays.sort(answer, (o1, o2) -> {
            int len1 = Math.abs(rCenter- o1[0]) + Math.abs(cCenter -o1[1]);
            int len2 = Math.abs(rCenter- o2[0]) + Math.abs(cCenter -o2[1]);
            return len1 - len2;
        });

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(allCellsDistOrder(2,3,1,2)));
    }
}
