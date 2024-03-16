package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 경쟁적 전염
 */
public class A18405_2 {
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // K가 필요가없네..

        int[][] arr = new int[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    visited[i][j] = true;
                    // 큐를 더해야함.
                    queue.add(new int[]{i, j, arr[i][j]});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 바이러스의 번호
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        while(!queue.isEmpty()) {
            if(S == 0) break;
            List<int[]> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                int[] info = queue.poll();
                int r = info[0];
                int c = info[1];
                list.add(new int[]{r,c, info[2]});
            }

            for (int i = 0; i < list.size(); i++) {
                int[] info = list.get(i);
                int r = info[0];
                int c = info[1];
                for (int k = 0; k < 4; k++) {
                    int newR = r + dir[k][0];
                    int newC = c + dir[k][1];
                    if(newR > 0 && newC > 0 && newR <= N && newC <= N && !visited[newR][newC] && arr[newR][newC] == 0) {
                        int num = info[2];
                        arr[newR][newC] = num;
                        visited[newR][newC] = true;
                        queue.add(new int[] {newR, newC, num});
                    }
                }
            }
            S--;
        }

        System.out.println(arr[X][Y]);
    }
}
