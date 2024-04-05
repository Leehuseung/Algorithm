package backjun.dp;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 */
public class A9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수
        int[] dp = new int[12]; // 1, 2, 3의 합으로 나타내는 방법의 수를 저장할 배열

        // 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 테스트 케이스의 개수만큼 반복
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 정수 n 입력
            // n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 과정
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
