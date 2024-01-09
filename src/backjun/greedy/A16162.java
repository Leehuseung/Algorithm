package backjun.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가희와 3단 고음
 */
public class A16162 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == A){
               result++;
               A += D;
            }
        }
        System.out.println(result);
    }
}
