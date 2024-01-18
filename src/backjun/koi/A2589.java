package backjun.koi;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A2589{
/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
 */
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String arr[][];
    static int isVisit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n][m];
        isVisit = new int[n][m];

        // 입력 값을 배열에 초기화
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j)+"";
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j].equals("L")){
                    isVisit = new int[n][m];
//                    System.out.println("n : "+ i);
//                    System.out.println("m : "+ j);
                    int num = bfs(i,j);
//                    System.out.println("bps 결과 : " + num);
//                    System.out.println("------------------=-=-=-=-----");
                    if(num > max){
                        max = num;
                    };
                }
            }
        }
        System.out.println(max);
    }

    // bfs method
    public static int bfs(int n, int m){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(n,m,0));

        isVisit[n][m] = 1;
        int returnNum = 0;

        int[] arrX = {0,0,1,-1};
        int[] arrY = {1,-1,0,0};

        while(!queue.isEmpty()){

            Point p = queue.poll();

            int x = p.x;
            int y = p.y;
            if(returnNum < p.count){
                returnNum = p.count;
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + arrX[i];
                int yy = y + arrY[i];

                if(checkLocation(xx,yy)){
                    isVisit[xx][yy] = isVisit[x][y] + 1;
                    queue.add(new Point(xx,yy,p.count + 1));
                }
            }
        }

        return returnNum;
    }

    private static boolean checkLocation(int xx, int yy) {
        if(xx < 0 || yy < 0 || xx > n-1 || yy > m-1){
            return false;
        }
        if(isVisit[xx][yy] != 0 || arr[xx][yy].equals("W")){
            return false;
        }
        return true;
    }

    static class Point{
        int x;
        int y;
        int count;
        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
