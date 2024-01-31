package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 농장 관리
 */
public class A1245 {
    static int r, c, ans = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean check = true;
    static int[][] dt = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                check=true;
                if(!visited[i][j]){
                    dfs(i,j);
                    if(check) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int rr, int cc) {
        if(visited[rr][cc]) {
            return;
        }
        visited[rr][cc] = true;
        for (int i = 0; i < 8; i++) {
            int newR = rr + dt[i][0];
            int newC = cc + dt[i][1];
            if(newR >= 0 && newC >= 0 && newR < r && newC < c){
                if (map[rr][cc] == map[newR][newC]) {
                    dfs(newR, newC);
                }else if(map[rr][cc] < map[newR][newC]) {
                    check = false;
                }
            }
        }
    }
}
