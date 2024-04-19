package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳
 */
public class A1987 {
    static char[][] map;
    static int R;
    static int C;
    static int result;
    static boolean[] visited;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[30];

        result = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0,0,1);

        System.out.println(result);
    }

    private static void dfs(int r, int c, int cnt) {
        if(visited[map[r][c]-'A']) {
            return;
        }
        visited[map[r][c]-'A'] = true;
        result = Math.max(cnt, result);
        for (int k = 0; k < 4; k++) {
            int newR = r + dir[k][0];
            int newC = c + dir[k][1];
            if(newR >= 0 && newC >= 0 && newR < R && newC < C){
                dfs(newR, newC, cnt+1);
            }
        }
        visited[map[r][c]-'A'] = false;
    }
}
