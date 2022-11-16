package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1380. Lucky Numbers in a Matrix
 */
public class LuckyNumbersinaMatrix {
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < matrix[0].length; i++) {
            int num = 0;
            for (int j = 0; j < matrix.length; j++) {
                if(num < matrix[i][j]){
                    num = matrix[i][j];
                }
            }
        }


        return list;
    }
    public static List<Integer> luckyNumbers2 (int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            loop:
            for (int j = 0; j < matrix[i].length; j++) {
                // i = row, j = col
                int row = i;
                int col = j;

                int num = matrix[i][j];

                //row 는 Max
                for (int k = 0; k < matrix.length; k++) {
                    if(num < matrix[k][col]){
                        continue loop;
                    }
                }

                //col 은 Minimum
                for (int k = 0; k < matrix[0].length; k++) {
                    if(num > matrix[row][k]){
                        continue loop;
                    }
                }

                list.add(num);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
    }
}
