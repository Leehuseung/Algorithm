package backjun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 */
public class A7569 {
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
        int cnt = 0;
        int changeCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 0) cnt++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int queCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(box[i][j][k] == 1 && !visited[i][j][k]){
                        queue.add(new int[]{i,j,k});
                        visited[i][j][k] = true;
                        queCnt++;
                    }
                }
            }
        }

        int result = 0;
        while(true){
            boolean check = false;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                queCnt--;
                for (int[] ints : dir) {
                    int newH = arr[0] - ints[0];
                    int newN = arr[1] - ints[1];
                    int newM = arr[2] - ints[2];
                    if (newH >= 0 && newN >= 0 && newM >= 0 && newH < H && newN < N && newM < M
                            && box[newH][newN][newM] == 0
                            && !visited[newH][newN][newM]) {
                        box[newH][newN][newM] = 1;
                        visited[newH][newN][newM] = true;
                        changeCnt++;
                        queue.add(new int[]{newH, newN, newM});
                        check = true;
                    }
                }
                if(queCnt == 0 && !queue.isEmpty()) {
                    queCnt = queue.size();
                    result++;
                }
            }
            if(!check) break;
        }
        System.out.println(cnt != changeCnt ? -1 : result);
    }
}
