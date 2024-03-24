package backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 */
public class A7569_2 {
    static int M;
    static int N;
    static int H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[][] dir = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        int changeCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        queue.add(new int[]{i,j,k});
                    } else if(box[i][j][k] == 0) {
                        changeCnt++;
                    }
                }
            }
        }

        int qs = queue.size();

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int h = info[0];
            int r = info[1];
            int c = info[2];

            for (int i = 0; i < dir.length; i++) {
                int newH = h - dir[i][0];
                int newR = r - dir[i][1];
                int newC = c - dir[i][2];
                if (newH >= 0 && newR >= 0 && newC >= 0 && newH < H && newR < N && newC < M
                        && box[newH][newR][newC] == 0
                        && !visited[newH][newR][newC]) {
                    visited[newH][newR][newC] = true;
                    queue.add(new int[]{newH, newR, newC});
                    changeCnt--;
                }
            }

            qs--;
            if(qs == 0) {
                qs = queue.size();
                answer++;
            }
        }

        System.out.println(changeCnt != 0 ? -1 : answer-1);
    }
}
