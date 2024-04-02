package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 탈출
 */
public class A3055 {
    static char[][] map;
    static int R;
    static int C;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        visited = new boolean[R][C];
        int[] sInfo = new int[2];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'S'){
                    sInfo = new int[]{i,j};
                }
            }
        }

        visited[sInfo[0]][sInfo[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sInfo[0], sInfo[1], 0});

        int qs = 1;
        nextWater();
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int cnt = info[2];
            for (int k = 0; k < 4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];
                if(newR >= 0 && newC >= 0 && newR < R && newC < C && !visited[newR][newC] && map[newR][newC] == '.'){
                    queue.add(new int[]{newR, newC, cnt+1});
                    visited[newR][newC] = true;
                    continue;
                }
                if(newR >= 0 && newC >= 0 && newR < R && newC < C && map[newR][newC] == 'D') {
                    System.out.println(cnt+1);
                    return;
                }
            }
            qs--;
            if(qs == 0){
                qs = queue.size();
                nextWater();
            }
        }

        System.out.println("KAKTUS");
    }

    static void nextWater () {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == '*'){
                    for (int k = 0; k < 4; k++) {
                        int newR = i + dir[k][0];
                        int newC = j + dir[k][1];
                        if(newR >= 0 && newC >= 0 && newR < R && newC < C && (map[newR][newC] == '.' || map[newR][newC] == 'S' )){
                            list.add(new int[]{newR,newC});
                        }
                    }
                }
            }
        }

        for (int[] a : list) map[a[0]][a[1]] = '*';
    }
}
