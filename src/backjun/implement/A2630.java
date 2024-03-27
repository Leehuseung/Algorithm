package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 */
public class A2630 {
    static int whiteCnt;
    static int blueCnt;
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(new int[]{1,n}, new int[] {1,n}, n);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void recursive(int[] raw, int[] col, int k) {
        int startRawIndex = raw[0];
        int endRawIndex = raw[1];
        int startColIndex = col[0];
        int endColIndex = col[1];
        k = k/2;

        //모두 일치하는지 검사한다.
        int type = map[startRawIndex][startColIndex];
        loop :
        for (int i = startRawIndex; i <= endRawIndex; i++) {
            for (int j = startColIndex; j <= endColIndex; j++) {
                if(type != map[i][j]) break loop;
                //마지막까지 왔다면 카운트를 더하고 리턴한다.
                if(i == endRawIndex && j == endColIndex) {
                    if(type == 0) whiteCnt++;
                    else blueCnt++;
                    return;
                }
            }
        }

        //아니었다면 4개로 나눠서 실행
        recursive(new int[]{startRawIndex, startRawIndex+k-1}, new int[]{startColIndex, startColIndex+k-1}, k);
        recursive(new int[]{startRawIndex, startRawIndex+k-1}, new int[]{startColIndex+k, endColIndex}, k);
        recursive(new int[]{startRawIndex+k, endRawIndex}, new int[]{startColIndex, startColIndex+k-1}, k);
        recursive(new int[]{startRawIndex+k, endRawIndex}, new int[]{startColIndex+k, endColIndex}, k);
    }
}
