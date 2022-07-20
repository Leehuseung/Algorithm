package leetcode.easy;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 */
public class CountNegativeNumbersinaSortedMatrix {

    public static int countNegatives(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] < 0){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}})); // 8
        System.out.println(countNegatives(new int[][]{{3,2},{1,0}})); // 0
    }

}
