package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사
 */
public class A14501_DP_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N까지만 일 함

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = P.length-1; i >= 1; i--) {
            int next = i + T[i];
            if(next > DP.length-1){
                DP[i] = DP[i+1];
            } else {
                DP[i] = Math.max(DP[i+1], DP[next] + P[i]);
            }
        }

        System.out.println(DP[1]);
    }
}