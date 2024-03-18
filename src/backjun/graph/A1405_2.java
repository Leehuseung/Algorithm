package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미친 로봇
 */
public class A1405_2 {
    static int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    static boolean[][] visited;
    static double result;
    static int n;
    static double E;
    static double W;
    static double S;
    static double N;
    static double[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        E = Double.parseDouble(st.nextToken()) * 0.01;
        W = Double.parseDouble(st.nextToken()) * 0.01;
        S = Double.parseDouble(st.nextToken()) * 0.01;
        N = Double.parseDouble(st.nextToken()) * 0.01;
        d = new double[4];
        d[0] = E;
        d[1] = W;
        d[2] = S;
        d[3] = N;
        visited = new boolean[30][30];
        result = 0;
        dfs(15,15,0, 1);
        System.out.println(result);
    }

    private static void dfs(int r, int c, int i, double t) {
        if(visited[r][c]) return;
        visited[r][c] = true;
        if(i == n) {
            result += t;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int newR = r + dir[k][0];
            int newC = c + dir[k][1];
            if(newR >= 0 && newC >= 0 && newR < 30 && newC < 30){
                if(!visited[newR][newC]) {
                    dfs(newR,newC,i+1, t * d[k]);
                    visited[newR][newC] = false;
                }
            }
        }
    }
}
