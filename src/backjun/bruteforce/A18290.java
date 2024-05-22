package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * NM과 K (1)
 */
public class A18290 {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static boolean[][] visited;
    static int sum;
    static int answer[];
    static int answerDir[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        answer = new int[k];
        answerDir = new int[k][];
        sum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       dfs(0,0,0);

       System.out.println(sum);
    }

    private static void dfs(int rr, int cc,int depth) {
        if(depth == k){
            for (int i = 0; i < answerDir.length; i++) {
                for (int j = i+1; j < answerDir.length; j++) {
                    int[] f = answerDir[i];
                    int[] b = answerDir[j];
                    if(Math.abs(f[0] - b[0]) + Math.abs(f[1] - b[1]) == 1){
                        return;
                    }
                }
            }
            sum = Math.max(Arrays.stream(answer).sum(), sum);
            return;
        }

        for (int i = rr; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    answer[depth] = arr[i][j];
                    answerDir[depth] = new int[]{i,j};
                    dfs(i,j,depth + 1);
                    visited[i][j] = false;
                }
            }
        }
    }
}
/*
2 2 2
4 5
5 4

ans : 10

3 3 4
100 10 1
1000 2 1
10000 10 10000

ans : 20102

 */