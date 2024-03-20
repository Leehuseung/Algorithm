package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 solved.ac
 */
public class A18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 난이도 의견의 개수
        int[] opinions = new int[n]; // 의견을 저장할 배열
        for (int i = 0; i < n; i++) opinions[i] = Integer.parseInt(br.readLine());
        Arrays.sort(opinions);

        // 30% 절사평균 계산
        double exclude = n * 0.15; // 제외될 사람 수
        int sum = 0;
        int e = (int)Math.round(exclude);
        for (int i = e; i < n - e; i++) {
            sum += opinions[i];
        }
        int average = (int) Math.round((double) sum / (n - 2 * e));

        System.out.println(average); // 계산된 문제의 난이도 출력
    }
}
