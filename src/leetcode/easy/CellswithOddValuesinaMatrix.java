package leetcode.easy;

/**
 * 1252. Cells with Odd Values in a Matrix
 */
public class CellswithOddValuesinaMatrix {

    public static int oddCells(int m, int n, int[][] indices) {
        int answer = 0;
        int[][] arr = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            int r = indices[i][0];
            for (int j = 0; j < arr[r].length; j++) {
                arr[r][j] = arr[r][j] + 1;
            }

            int c = indices[i][1];
            for (int j = 0; j < arr.length; j++) {
                arr[j][c] = arr[j][c] + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] % 2 == 1){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(oddCells(2,3,new int[][]{{0,1},{1,1}})); // 6
//        System.out.println(oddCells(2,2,new int[][]{{1,1},{0,0}})); // 0
        System.out.println(oddCells(48,37,new int[][]{{40,5}})); // 83
    }
}
