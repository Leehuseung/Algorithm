package leetcode.easy;

/**
 * Matrix Diagonal Sum
 */
public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int answer = 0;

        for (int i = 0; i < mat.length; i++) {
            answer += mat[i][i];
            answer += mat[i][mat.length-1-i];
        }

        if(mat.length == 1){
            answer -= mat[0][0];
        } else if(mat.length % 2 == 1){
            int k = mat.length / 2;
            answer -= mat[k][k];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}})); // 25
        System.out.println(diagonalSum(new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}})); // 8
        System.out.println(diagonalSum(new int[][]{{5}})); // 5
    }
}
