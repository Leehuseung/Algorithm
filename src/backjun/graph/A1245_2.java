package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 농장 관리
 */
public class A1245_2 {
    static int r, c, ans = 0;
    static int[][] map;
    static boolean[][] visited;
    static boolean check = true;
    static int[][] dt = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
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

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    check = true;
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()) {
                        int[] rc = queue.poll();
                        int rr = rc[0];
                        int cc = rc[1];
                        for (int k = 0; k < 8; k++) {
                            int newR = rr + dt[k][0];
                            int newC = cc + dt[k][1];
                            if(newR >= 0 && newC >= 0 && newR < r && newC < c){
                                if(map[rr][cc] < map[newR][newC]) {
                                    check = false;
                                }
                                if(visited[newR][newC]) continue;
                                if (map[rr][cc] == map[newR][newC]) {
                                    queue.add(new int[]{newR, newC});
                                    visited[newR][newC] = true;
                                }
                            }
                        }
                    }
                    if(check)
                        ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
