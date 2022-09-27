package leetcode.easy;

/**
 * 2319. Check if Matrix Is X-Matrix
 */
public class CheckifMatrixIsXMatrix {

    public static boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i == j && grid[i][j] == 0){
                    return false;
                }
                if(i+j == grid.length-1 && grid[i][j] == 0){
                    return false;
                }
                if( (i != j) && (i+j != grid.length-1) && grid[i][j] != 0){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkXMatrix(new int[][]{
                {5,0,0,1},
                {0,4,1,5},
                {0,5,2,0},
                {4,1,0,2}
        })); // false
    }
}
