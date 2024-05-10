package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 */
public class A1654_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long pr = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            pr = Math.max(arr[i], pr);
        }


        long pl = 1;
        long len = 0;
        while(pl <= pr) {
            long cnt = 0;
            long t = (pr + pl) / 2;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / t;
            }
            if(cnt < N) {
                pr = t - 1;
            } else if(cnt >= N) {
                len = Math.max(len, t);
                pl = t + 1;
            }
        }
        System.out.println(len);
    }
}