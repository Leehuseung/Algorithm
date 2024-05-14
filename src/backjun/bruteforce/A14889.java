package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스타트와 링크
 */
public class A14889 {
    static int[][] arr;
    static boolean[] teams;
    static int n;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][];
        teams = new boolean[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);
        System.out.println(min);
    }

    private static void recursive(int start , int depth) {
        if(depth == n/2) {
            int t = 0;
            int f = 0;
            // true 팀 계산
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if(teams[i] && teams[j]){
                        t += arr[i][j];
                        t += arr[j][i];
                    } else if( !teams[i] && !teams[j]){
                        f += arr[i][j];
                        f += arr[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(t-f));
            return;
        }

        for (int i = start; i < n; i++) {
            if(!teams[i]) {
                teams[i] = true;
                recursive(i, depth+1);
                teams[i] = false;
            }
        }
    }
}
