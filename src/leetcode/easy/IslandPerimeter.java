package leetcode.easy;

/**
 * 463. Island Perimeter
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int cnt = 0;
                    if(i != 0 && grid[i-1][j] == 1) cnt++;
                    if(j != 0 && grid[i][j-1] == 1) cnt++;
                    if((i+1) < grid.length && grid[i+1][j] == 1) cnt++;
                    if((j+1) < grid[i].length && grid[i][j+1] == 1) cnt++;
                    answer += (4-cnt);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(islandPerimeter(new int[][]{{1}}));
    }
}
