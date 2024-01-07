package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 서강근육맨
 */
public class A20300 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextLong();
        }

        Arrays.sort(arr);
        long result = 0;
        boolean even = N % 2 == 0;
        int k = N / 2;
        int end = even ? N-1 : N-2;
        for (int i = 0; i < k; i++) {
            result = Math.max(result, arr[i]+arr[end]);
            end--;
        }
        //홀수면
        if(!even) {
            result = Math.max(result, arr[N-1]);
        }
        System.out.println(result);
    }
}
