package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 테트로미노
 */
public class A14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        //사각형
        for (int i = 0; i <= R-2; i++) {
            for (int j = 0; j <= C-2; j++) {
                int mm = 0;
                mm = (map[i][j] + map[i+1][j+1] + map[i+1][j] + map[i][j+1]);
                max = Math.max(mm, max);
            }
        }

        //세로
        for (int i = 0; i < R; i++) {
            for (int j = 0; j <= C-4; j++) {
                int mm = 0;
                mm = (map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);
                max = Math.max(mm, max);
            }
        }

        //가로
        for (int i = 0; i <= R-4; i++) {
            for (int j = 0; j < C; j++) {
                int mm = 0;
                mm = (map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);
                max = Math.max(mm, max);
            }
        }

        // 2 x 3
        boolean[][] arr1 = {{false,true,false} ,{true,true,true}};
        boolean[][] arr2 = {{true,true,true}   ,{false,true,false}};
        boolean[][] arr3 = {{false,false,true} ,{true,true,true}};
        boolean[][] arr4 = {{true,true,true}   ,{true,false,false}};
        boolean[][] arr5 = {{true,true,false}  ,{false,true,true}};
        boolean[][] arr6 = {{true,false,false}  ,{true,true,true}};
        boolean[][] arr7 = {{true,true,true}  ,{false,false,true}};
        boolean[][] arr8 = {{false,true,true}  ,{true,true,false}};
        boolean[][][] arr = {arr1,arr2,arr3,arr4,arr5,arr6,arr7,arr8};
        for (int i = 0; i <= R-2; i++) {
            for (int j = 0; j <= C-3; j++) {

                for (int k = 0; k < arr.length; k++) {
                    boolean[][] bools = arr[k];
                    int mm = 0;
                    if(bools[0][0])  mm += map[i][j];
                    if(bools[0][1])  mm += map[i][j+1];
                    if(bools[0][2])  mm += map[i][j+2];
                    if(bools[1][0])  mm += map[i+1][j];
                    if(bools[1][1])  mm += map[i+1][j+1];
                    if(bools[1][2])  mm += map[i+1][j+2];
                    max = Math.max(mm, max);
                }

            }
        }

        // 3 x 2
        boolean[][] rc1 = {{false, true} ,{true, true}, {true, false}};
        boolean[][] rc2 = {{true, false} ,{true, true}, {true, false}};
        boolean[][] rc3 = {{false, true} ,{true, true}, {false, true}};
        boolean[][] rc4 = {{true, false} ,{true, false}, {true, true}};
        boolean[][] rc5 = {{true, true} ,{false, true}, {false, true}};
        boolean[][] rc6 = {{false, true} ,{false, true}, {true, true}};
        boolean[][] rc7 = {{true, true} ,{true, false}, {true, false}};
        boolean[][] rc8 = {{true, false} ,{true, true}, {false, true}};
        arr = new boolean[][][]{rc1, rc2, rc3, rc4, rc5, rc6, rc7, rc8};

        for (int i = 0; i <= R-3; i++) {
            for (int j = 0; j <= C-2; j++) {

                for (int k = 0; k < arr.length; k++) {
                    boolean[][] bools = arr[k];
                    int mm = 0;
                    if(bools[0][0])  mm += map[i][j];
                    if(bools[0][1])  mm += map[i][j+1];
                    if(bools[1][0])  mm += map[i+1][j];
                    if(bools[1][1])  mm += map[i+1][j+1];
                    if(bools[2][0])  mm += map[i+2][j];
                    if(bools[2][1])  mm += map[i+2][j+1];
                    max = Math.max(mm, max);
                }

            }
        }

        System.out.println(max);
    }
}
