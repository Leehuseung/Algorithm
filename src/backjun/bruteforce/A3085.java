package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사탕 게임
 */
public class A3085 {
    static char[][] arr;
    static int[][] dir = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];
                    if(newR >= 0 && newC >= 0 && newR < n && newC < n){
                        char original = arr[i][j];
                        char change = arr[newR][newC];

                        arr[newR][newC] = original;
                        arr[i][j] = change;

                        int cc = cntMax();
                        max = Math.max(max, cc);

                        arr[i][j] = original;
                        arr[newR][newC] = change;
                    }
                }
            }
        }



        System.out.println(max);
    }

    public static int cntMax () {
        int leftToRight = 0;

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    cnt++;
                    leftToRight = Math.max(cnt, leftToRight);
                } else {
                    cnt = 1;
                }
            }
        }

        int topToBottom = 0;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j][i] == arr[j+1][i]) {
                    cnt++;
                    leftToRight = Math.max(cnt, leftToRight);
                } else {
                    cnt = 1;
                }
            }
        }

        return Math.max(topToBottom, leftToRight);
    }

}
