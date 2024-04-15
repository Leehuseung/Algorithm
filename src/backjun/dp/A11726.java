package backjun.dp;

import java.io.*;

/**
 * 2 x n 타일링
 */
public class A11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 타일링 방법의 수를 저장할 배열
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }

        // 동적 계획법을 이용하여 각 경우에 대한 타일링 방법의 수 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        // 결과 출력
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
