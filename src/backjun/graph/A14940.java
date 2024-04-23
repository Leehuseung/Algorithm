package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 쉬운 최단거리
 */
public class A14940 {
    static int[][] map;
    static int[][] answerMap;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    static boolean[][] bools;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        bools = new boolean[n][m];
        answerMap = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    bools[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int r = arr[0];
            int c = arr[1];
            int cnt = arr[2];
            for (int k = 0; k < 4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];
                if(newR >= 0 && newC >= 0 && newR < n && newC < m && !bools[newR][newC] && map[newR][newC] != 0){
                    bools[newR][newC] = true;
                    answerMap[newR][newC] = cnt+1;
                    queue.add(new int[]{newR,newC,cnt+1});
                } else if(newR >= 0 && newC >= 0 && newR < n && newC < m && !bools[newR][newC] && map[newR][newC] == 0) {
                    bools[newR][newC] = true;
                }
            }
        }

        for (int i = 0; i < answerMap.length; i++) {
            for (int j = 0; j < answerMap[i].length; j++) {
                if(!bools[i][j] && map[i][j] != 0){
                    System.out.print(-1+ " ");
                    continue;
                }
                System.out.print(answerMap[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
