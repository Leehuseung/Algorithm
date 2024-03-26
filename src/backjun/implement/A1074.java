package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Z
 */
public class A1074 {
    static int n;
    static int r;
    static int c;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);

        recursive(new int[]{0,n-1}, new int[] {0,n-1}, n);
    }

    static boolean recursive(int[] raw, int[] col, int k) {
        int startRawIndex = raw[0];
        int endRawIndex = raw[1];
        int startColIndex = col[0];
        int endColIndex = col[1];
        k = k/2;

        int middleRaw = (startRawIndex + endRawIndex) / 2;
        int middleCol = (startColIndex + endColIndex) / 2;

        int sa = 0;
        if(r <= middleRaw && c <= middleCol){
            sa = 1;
        } else if (r <= middleRaw && c > middleCol){
            sa = 2;
        } else if (r > middleRaw && c <= middleCol){
            sa = 3;
        } else {
            sa = 4;
        }

        if(k == 0) {
            System.out.println(count);
            return true;
        }

        //아니었다면 4개로 나눠서 실행
        count += (k * k * (sa - 1));
        if(sa == 1) {
            if(recursive(new int[]{startRawIndex, startRawIndex+k-1}, new int[]{startColIndex, startColIndex+k-1}, k))
                return true;
        } else if (sa == 2) {
            if(recursive(new int[]{startRawIndex, startRawIndex+k-1}, new int[]{startColIndex+k, endColIndex}, k))
                return true;
        } else if (sa == 3) {
            if(recursive(new int[]{startRawIndex+k, endRawIndex}, new int[]{startColIndex, startColIndex+k-1}, k))
                return true;
        } else {
            if(recursive(new int[]{startRawIndex+k, endRawIndex}, new int[]{startColIndex+k, endColIndex}, k))
                return true;
        }

        return false;
    }
}
