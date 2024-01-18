package backjun.etc;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
4 6
101111
101010
101011
111011
 */
public class A2178 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][];
    static int isVisit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        isVisit = new int[n][m];


        // 입력 값을 배열에 초기화
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }
        bfs();
    }

    // bfs method
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0,0));

        isVisit[0][0] = 1;

        int[] arrX = {0,0,1,-1};
        int[] arrY = {1,-1,0,0};

        while(!queue.isEmpty()){

            Point p = queue.poll();

            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int xx = x + arrX[i];
                int yy = y + arrY[i];

                if(checkLocation(xx,yy)){
                    isVisit[xx][yy] = isVisit[x][y] + 1;
                    queue.add(new Point(xx,yy));
                }
            }
        }
        System.out.println(isVisit[n-1][m-1]);
    }

    private static boolean checkLocation(int xx, int yy) {

        if(xx < 0 || yy < 0 || xx > n-1 || yy > m-1){
            return false;
        }
        if(isVisit[xx][yy] != 0 || arr[xx][yy] == 0){
            return false;
        }

        return true;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



}

