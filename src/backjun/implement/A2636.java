package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈
 */
public class A2636 {
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        boolean[][] visited = new boolean[row][col];


        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> cheseQueue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            for (int k = 0; k < 4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];
                if(newR >= 0 && newC >= 0 && newR < row && newC < col){
                    if(!visited[newR][newC]) {
                        visited[newR][newC] = true;
                        if(arr[newR][newC] == 0){
                            queue.add(new int[]{newR, newC});
                        } else {
                            cheseQueue.add(new int[]{newR, newC});
                        }
                    }
                }
            }
            if(queue.isEmpty()) {
                visited = new boolean[row][col];
                if(!cheseQueue.isEmpty()) {
                    cnt = cheseQueue.size();
                }
                while(!cheseQueue.isEmpty()) {
                    int[] cheese = cheseQueue.poll();
                    int cr = cheese[0];
                    int cc = cheese[1];
                    arr[cr][cc] = 0;
                    if(cheseQueue.isEmpty()) {
                        queue.add(new int[]{cr,cc});
                        time++;
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }
}
