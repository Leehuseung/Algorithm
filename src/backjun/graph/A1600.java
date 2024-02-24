package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 말이 되고픈 원숭이
 */
public class A1600 {
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    static int[][] dir2 = new int[][]{ {-2,-1}, {-1,-2}, {1,-2}, {2,-1}, {-2,1}, {-1,2}, {2,1}, {1,2} };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        boolean[][][] visited = new boolean[R][C][31];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        //x,y,이동횟수,k사용횟수
        queue.add(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int cnt = info[2];
            int chance = info[3];
            if(c == C-1 && r == R-1){
                System.out.println(cnt);
                return;
            }
            if(chance >= 30) continue;

            for (int k = 0; k < 4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];
                if(newR >= 0 && newC >= 0 && newR < R && newC < C && !visited[newR][newC][chance]
                        && map[newR][newC] != 1){
                    visited[newR][newC][chance] = true;
                    queue.add(new int[]{newR,newC,cnt+1, chance});
                }
            }

            for (int i = 0; i < dir2.length; i++) {
                int newR = r + dir2[i][0];
                int newC = c + dir2[i][1];
                if(newR >= 0 && newC >= 0 && newR < R && newC < C && !visited[newR][newC][chance+1]
                        && map[newR][newC] != 1 && chance < K){
                    visited[newR][newC][chance+1] = true;
                    queue.add(new int[]{newR,newC,cnt+1, chance+1});
                }
            }
        }

        System.out.println(-1);
    }
}

