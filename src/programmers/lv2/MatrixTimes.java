package programmers.lv2;

import java.util.Arrays;

/**
 * Lv.2 행렬의 곱셈
 */
public class MatrixTimes {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                int[] xArr = getXarr(arr1,i);
                int[] yArr = getYarr(arr2,j);
                for (int k = 0; k < xArr.length; k++) {
                    answer[i][j] += (xArr[k] * yArr[k]);
                }
            }
        }
        return answer;
    }

    public static int[] getXarr(int[][] arr, int x){
        int[] ans = new int[arr[x].length];
        for (int i = 0; i < arr[x].length; i++) {
            ans[i] = arr[x][i];
        }
        return ans;
    }

    public static int[] getYarr(int[][] arr, int y){
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i][y];
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{ {1,4},{3,2},{4,1} },new int[][]{{3,3},{3,3}}))); // [[15, 15], [15, 15], [15, 15]]
//        System.out.println(Arrays.toString(solution(new int[][]{ {2,3,2},{4,2,4},{3,1,4} },new int[][]{ {5,4,3},{2,4,1},{3,1,1} }))); // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
    }
}
