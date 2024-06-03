package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이동하기
 */
public class A11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][];
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String ss[] = s.split(" ");
            map[i] = new int[m];
            dp[i] = new int[m];
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }
        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i+1 < n){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + map[i+1][j]);
                }
                if(j+1 < m){
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + map[i][j+1]);
                }
                if(i+1 < n && j+1 < m){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + map[i+1][j+1]);
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
