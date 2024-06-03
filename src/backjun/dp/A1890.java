package backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프
 */
public class A1890 {
    static int[][] map;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][];
        dp = new int[n][];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String ss[] = s.split(" ");
            map[i] = new int[n];
            dp[i] = new int[n];
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(ss[j]);
            }
        }

        a(0,0);
        System.out.println(dp[n-1][n-1]);
    }

    public static void a(int r, int c){
        if(r >= n || c >= n){
            return;
        }
        if(r >= n-1 && c >= n-1){
            return;
        }
        int rightR = r;
        int rightC = c + map[r][c];
        if(rightR < n && rightC < n) {
            dp[rightR][rightC]++;
            a(rightR, rightC + map[rightR][rightC]);
            a(rightR + map[rightR][rightC], rightC);
        }
        int bottomR = r + map[r][c];
        int bottomC = c;
        if(bottomR < n && bottomC < n) {
            dp[bottomR][bottomC]++;
            a(bottomR, bottomC + map[bottomR][bottomC]);
            a(bottomR + map[bottomR][bottomC], bottomC);
        }
    }
}
