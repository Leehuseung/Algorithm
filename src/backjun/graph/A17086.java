package backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 아기 상어2
 */
public class A17086 {
    static int r, c;
    static int[][] graph;
    static int[][] safe;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[][] roll = new int[][]{{-1,-1},{-1,0},{-1,1}, {0,-1}, {0,1},{ 1,-1},{ 1,0},{1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        queue = new LinkedList<>();
        graph = new int[r][c];
        safe = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                graph[i][j] = sc.nextInt();
                safe[i][j] = 0;
            }
        }

        //순회한다.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(graph[i][j] == 1){
                    visited = new boolean[r][c];
                    visited[i][j] = true;
                    bfs(i,j,1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(safe[i][j] , max);
            }
        }
        System.out.println(max);
    }

    private static void bfs(int rr, int cc, int i) {
        for (int[] ints : roll) {
            int newR = ints[0] + rr;
            int newC = ints[1] + cc;
            if (newR >= 0 && newC >= 0 && newR < r && newC < c && !visited[newR][newC] && graph[newR][newC] != 1) {
                queue.add(new int[]{newR,newC,i+1});
                visited[newR][newC] = true;
                if(safe[newR][newC] == 0){
                    safe[newR][newC] = i;
                } else if(safe[newR][newC] > i){
                    safe[newR][newC] = i;
                }
            }
        }

        //다 처리하고나서
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            bfs(arr[0], arr[1], arr[2]);
        }
    }
}
