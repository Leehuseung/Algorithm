package backjun.dp;

import java.util.Scanner;

/**
 * 피보나치 함수
 */
public class A1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;

        one[0] = 0;
        one[1] = 1;

        for (int i = 2; i < one.length; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }
        
        for (int i = 0; i < N; i++) {
            int k = arr[i];
            System.out.println(zero[k] + " " + one[k]);
        }
    }
}