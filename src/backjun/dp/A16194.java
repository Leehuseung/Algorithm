package backjun.dp;

import java.util.Scanner;

/**
 * 카드 구매하기 2
 */
public class A16194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[j]+arr[i-j]);
            }
        }
        System.out.println(dp[N]);
    }
}