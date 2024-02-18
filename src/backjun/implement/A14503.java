package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 */
public class A14503 {
    static int result;
    static int N;
    static int M;
    static boolean[][] block;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        result = 0;
        int[][] arr = new int[N][M];
        block = new boolean[N][M];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    block[i][j] = true;
                }
            }
        }

        Robot robot = new Robot(r,c,d,arr);

        robot.start();

        System.out.println(result);
    }
    static class Robot {
        int[][] arr;
        int r;
        int c;
        int d;

        public Robot(int r, int c, int d, int[][] arr) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.arr = arr;
        }

        void start () {
            while(true) {
                cleanNowRoom();
                if(isCleanRoom()){
                    rotate();
                    while(!isMoveGo());
                    continue;
                }
                if(isBack()){
                    moveBack();
                    continue;
                }
                break;
            }
        }

        private boolean isBack() {
            int newR = r;
            int newC = c;
            if(d == 0) {
                newR = r+1;
            }else if(d == 1) {
                newC = c-1;
            }else if(d == 2) {
                newR = r-1;
            }else if(d == 3) {
                newC = c+1;
            }
            if(newR < 0 || newC < 0 || newR >= N || newC >= M){
               return false;
            }
            if(block[newR][newC]) {
                return false;
            }
            return true;
        }

        boolean isMoveGo() {
            int newR = r;
            int newC = c;
            if(d == 0) {
                newR = r-1;
            }else if(d == 1) {
                newC = c+1;
            }else if(d == 2) {
                newR = r+1;
            }else if(d == 3) {
                newC = c-1;
            }
            if(arr[newR][newC] == 0){
                r = newR;
                c = newC;
                return true;
            }
            rotate();
            return false;
        }

        void moveBack() {
            if(d == 0) {
                r++;
            }else if(d == 1) {
                c--;
            }else if(d == 2) {
                r--;
            }else if(d == 3) {
                c++;
            }
        }

        void rotate() {
            d--;
            if(d == -1){
                d = 3;
            }
        }

        private boolean isCleanRoom() {
            for (int k = 0; k < 4; k++) {
                int newR = r + dir[k][0];
                int newC = c + dir[k][1];
                if(newR >= 0 && newC >= 0 && newR < N && newC < M && arr[newR][newC] == 0){
                    return true;
                }
            }
            return false;
        }

        private void cleanNowRoom() {
            if(arr[r][c] == 0) {
                result++;
                arr[r][c] = 1;
            }
        }
    }
}