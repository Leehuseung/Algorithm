package leetcode.easy;

/**
 * 766. Toeplitz Matrix
 */
public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix[0].length; i++) {
            int r = 0;
            int c = i;
            int num = matrix[r][c];

            while(r < matrix.length && c < matrix[0].length){
                int num2 = matrix[r][c];
                if(num != num2){
                    return false;
                }
                r++;
                c++;
                num = num2;
            }
        }

        if(matrix.length > 1){
            for (int i = 1; i < matrix.length; i++) {
                int r = i;
                int c = 0;
                int num = matrix[r][c];

                while(r < matrix.length && c < matrix[0].length){
                    int num2 = matrix[r][c];
                    if(num != num2){
                        return false;
                    }
                    r++;
                    c++;
                    num = num2;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(isToeplitzMatrix(new int[][]{{1,2}, {2,2}}));
        System.out.println(isToeplitzMatrix(new int[][]{{18},{66}}));
    }
}
