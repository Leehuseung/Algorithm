package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z
 */
public class A1074_2 {
    static int n;
    static int r;
    static int c;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        recursive(n,r,c);
    }

    private static void recursive(int n, int r, int c) {
        if(n <= 0) {
            System.out.println(count);
            return;
        }
        long sum = (int) Math.pow(Math.pow(2, n-1), 2);
        int t = (int) Math.pow(2, n);
        int half = (t-1)/2+1;

        if(r < half && c < half) {
            recursive(n-1, r, c);
        }else if(r < half && c >= half) {
            count += sum;
            recursive(n-1, r, c-half);
        }else if(r >= half && c < half) {
            count += sum * 2;
            recursive(n-1, r-half, c);
        } else {
            count += sum * 3;
            recursive(n-1, r-half, c-half);
        }
    }
}
