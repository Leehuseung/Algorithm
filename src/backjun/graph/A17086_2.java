package backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 아기 상어
 */
public class A17086_2 {
    static int R, C;
    static int[][] graph;
    static Queue<int[]> queue;
    static int[][] dir = new int[][]{{-1,-1},{-1,0},{-1,1}, {0,-1}, {0,1},{ 1,-1},{ 1,0},{1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        queue = new LinkedList<>();
        graph = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int distance = 1;
        int max = 0;
        int qs = queue.size();
        while(!queue.isEmpty()) {
            qs--;
            int[] shark = queue.poll();
            for (int[] ints : dir) {
                int newR = shark[0] + ints[0];
                int newC = shark[1] + ints[1];
                if (newR >= 0 && newC >= 0 && newR < R && newC < C && graph[newR][newC] == 0) {
                    graph[newR][newC] = distance;
                    queue.add(new int[]{newR, newC});
                    max = Math.max(max, distance);
                }
            }
            if(qs == 0) {
                qs = queue.size();
                distance++;
            }
        }

        System.out.println(max);
    }
}
