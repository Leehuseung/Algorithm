package programmers.lv3;

/**
 * Lv3. 등굣길
 *
 * 힌트
 */
public class SchoolRoad {
    public static long solution(int m, int n, int[][] puddles) {
        long[][] arr = new long[n][m];

        for (int i = 0; i < puddles.length; i++) {
            arr[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                    continue;
                }

                if(i == 0 && j == 0){
                    arr[i][j] = 1;
                    continue;
                }
                if(i-1 < 0){
                    arr[i][j] = arr[i][j-1];
                    continue;
                }
                if(j-1 < 0){
                    arr[i][j] = arr[i-1][j];
                    continue;
                }

                arr[i][j] = arr[i][j-1] + arr[i-1][j];

                if(arr[i][j] > 1000000007){
                    arr[i][j] %= 1000000007;
                }
            }
        }

        return arr[n-1][m-1] % 1000000007;
    }



    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}})); // 4
    }
}