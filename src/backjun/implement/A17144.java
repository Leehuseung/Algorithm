package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미세먼지 안녕!
 */
public class A17144 {
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); //
        int C = Integer.parseInt(st.nextToken()); //
        int T = Integer.parseInt(st.nextToken()); //T초가 지난 후의 상황

        map = new int[R][C];
        int[][] spread = new int[R][C];

        int[] top = new int []{-1, -1};
        int[] bottom = new int []{};

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && top[0] == -1) {
                    top = new int[] {i,j};
                } else if(map[i][j] == -1) {
                    bottom = new int[] {i,j};
                }
            }
        }
        int result = 0;
        while(T-- > 0) {

            //1. 미세먼지가 확산한다.
            spread = new int[R][C];
            //확산량 먼저 계산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] != 0 && map[i][j] != -1){
                        spread[i][j] = map[i][j]/5;
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] != 0 && map[i][j] != -1){
                        int addDust = spread[i][j]; //더할 미세먼지
                        int sum = 0; // 더한 미세먼지
                        //확산한다.
                        for (int k = 0; k < 4; k++) {
                            int newR = i + dir[k][0];
                            int newC = j + dir[k][1];
                            if(newR >= 0 && newC >= 0 && newR < R && newC < C && map[newR][newC] != -1){
                                map[newR][newC] += addDust;
                                sum += addDust;
                            }
                        }
                        map[i][j] -= sum;  //모두 확산 했으면 확산한만큼 빼줘야 한다.
                    }
                }
            }

            //2.공기청정기가 작동한다.
            int topR = top[0];
            for (int i = topR-2; i >= 0; i--) map[i + 1][0] = map[i][0];        // 맨왼쪽을 아래로
            for (int i = 1; i < C; i++) map[0][i - 1] = map[0][i];              // 맨위를 왼쪽으로
            for (int i = 1; i <= topR; i++) map[i - 1][C - 1] = map[i][C - 1];  // 맨 오른쪽을 맨 위로
            for (int i = C-1; i > 0 ; i--) map[topR][i] = map[topR][i - 1];     // 청정기 옆에부터 오른쪽으로

            //아래 청정기
            int botR = bottom[0];
            for (int i = botR+2 ; i < R  ; i++) map[i - 1][0] = map[i][0];       // 왼쪽을 위로 올린다.
            for (int i = 1; i < C; i++) map[R - 1][i - 1] = map[R - 1][i];       //맨아래를 왼쪽으로 땡긴다.
            for (int i = R-1; i > botR; i--) map[i][C - 1] = map[i - 1][C - 1];  //오른쪽을 맨밑으로 땡긴다.
            for (int i = C-1; i > 1; i--) map[botR][i] = map[botR][i - 1];       //중간을 오른쪽으로 민다.

            map[topR][1] = 0;
            map[botR][1] = 0;
        }

        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (map[i][j] != -1) result += map[i][j];
        System.out.println(result);
    }
}
