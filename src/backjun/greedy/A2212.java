package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 센서
 */
public class A2212 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        if(K >= N){
            System.out.println(0);
            return;
        }

        int result = 0;
        Arrays.sort(arr);
        int[] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < N-K; i++) {
            result+=diff[i];
        }
        System.out.println(result);
    }
}
