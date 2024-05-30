package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 1
 */
public class A16926 {
    static int[][] arr;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[r][];

        int minRc = Math.min(r,c)/2;

        for (int i = 0; i < r; i++) {
            arr[i] = new int[c];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < minRc; i++) {
            for (int j = 0; j < n; j++) {
                changeArray(i,i);
            }
            c = c-1;
            r = r-1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void changeArray(int rr, int cc) {

        int tmp = arr[rr+1][cc];
        arr[rr+1][cc] = arr[rr][cc];

        // 0,0 에서 아래로
        for (int i = rr+2; i < r; i++) {
            tmp = getTmp(cc, tmp, i);
        }

        //하단 에서 오른쪽
        for (int i = cc+1; i < c; i++) {
            tmp = getTmp(i, tmp, r - 1);
        }

        //3,3 에서 위로
        for (int i = r-2; i >= rr; i--) {
            tmp = getTmp(c - 1, tmp, i);
        }

        //3,0 에서 왼쪽
        for (int i = c-2; i >= cc; i--) {
            tmp = getTmp(i, tmp, rr);
        }
    }

    private static int getTmp(int cc, int tmp, int i) {
        int tmp2 = tmp;
        tmp = arr[i][cc];
        arr[i][cc] = tmp2;
        return tmp;
    }
}
