package programmers.lv1;

import java.util.Arrays;

public class matrixAdd {

    public static void main(String[] args) {
        solution(new int[][]{{1,2},{2,3}},new int[][]{{3,4},{5,6}});
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];

        for (int i = 0; i < arr1.length; i++) {
            answer[i] = new int[arr1[i].length];
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
