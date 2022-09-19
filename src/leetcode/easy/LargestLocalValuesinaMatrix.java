package leetcode.easy;

/**
 * 2373. Largest Local Values in a Matrix
 */
public class LargestLocalValuesinaMatrix {
    public static int[][] largestLocal(int[][] grid) {
        int len = grid.length-2;
        int[][] answer = new int[len][];
        for (int i = 0; i < len; i++) {
            answer[i] = new int[len];
            for (int j = 0; j < len; j++) {
                int max = 0;
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        max = Math.max(grid[k][l],max);
                    }
                }
                answer[i][j] = max;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
