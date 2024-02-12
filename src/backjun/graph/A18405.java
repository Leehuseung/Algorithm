package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 경쟁적 전염
 */
public class A18405 {
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
                    queue.add(new int[]{i,j,arr[i][j]});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int second = 0;
        while (!queue.isEmpty()) {
            if(second == S) break;
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int num = info[2];
            //상하좌우를 변경한다
            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k][0];
                int newY = y + dir[k][1];
                if(newX >= 1 && newY >= 1 && newX <= N && newY <= N){
                    if(arr[newX][newY] == 0) {
                        arr[newX][newY] = num;
                    }
                }
            }

            if(queue.isEmpty()) {
                second ++;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if(arr[i][j] != 0 && !visited[i][j]) {
                            visited[i][j] = true;
                            queue.add(new int[]{i,j,arr[i][j]});
                        }
                    }
                }
            }
        }
        System.out.println(arr[X][Y]);
    }
}
/*
3 2
1 0 0
0 0 0
0 0 2
1 2 3
->

3 2
1 0 0
0 0 0
0 0 2
0 2 3
-> 0

3 2
1 0 0
0 0 0
0 0 2
3 2 3
-> 0

3 3
1 0 1
3 0 0
0 0 2
2 1 1

바이러스부터 검사
public class A18405 {
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(arr[i][j] == 0) {
                    boolean check = false;
                    for (int k = 0; k < 4; k++) {
                        int newX = i + dir[k][0];
                        int newY = j + dir[k][1];
                        if(newX >= 1 && newY >= 1 && newX <= N && newY <= N && arr[newX][newY] != 0){
                            check = true;
                        }
                    }
                    if(check) {
                        visited[i][j] = true;
                        queue.add(new int[]{i,j});
                    }
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int qs = queue.size();
        int second = 0;
        while (S != 0 && !queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            //상하좌우를 변경한다
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k][0];
                int newY = y + dir[k][1];
                if(newX >= 1 && newY >= 1 && newX <= N && newY <= N && arr[newX][newY] != 0){
                    min = Math.min(min, arr[newX][newY]);
                }
            }
            arr[x][y] = min == Integer.MAX_VALUE ? 0 : min;

            //qs 가 0이면  second를 증가
            qs--;
            if(qs == 0) {
                second ++;
                if(second == S) break;
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        boolean check = false;
                        for (int k = 0; k < 4; k++) {
                            int newX = i + dir[k][0];
                            int newY = j + dir[k][1];
                            if(newX >= 1 && newY >= 1 && newX <= N && newY <= N && arr[newX][newY] != 0){
                                check = true;
                            }
                        }
                        if(check && arr[i][j] == 0) {
                            queue.add(new int[]{i,j});
                        }
                    }
                }
            }
        }

        System.out.println(arr[X][Y] == Integer.MAX_VALUE ? 0 : arr[X][Y]);
    }
}
 */