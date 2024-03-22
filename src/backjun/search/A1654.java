package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 */
public class A1654 {
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
            long mid = (pl + pr)/2;
            long ccc = 0;
            for (int i = 0; i < arr.length; i++) {
                ccc += arr[i]/mid;
            }
            if(ccc >= N) len = mid;

            if(ccc < N) {
                pr = mid-1;
            } else {
                pl = mid+1;
            }
        }

        System.out.println(len);
    }
}
