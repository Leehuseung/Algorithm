package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 등수 구하기
 */
public class A1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int same = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            if(k > score) {
                result++;
            }
            if(k == score) {
                same++;
            }
        }
        if(result + same > p){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}
