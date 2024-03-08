package backjun.greedy;

import java.util.Scanner;

/**
 * 설탕 배달
 */
public class A2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 0; // 봉지의 개수

        // 5킬로그램 봉지로 최대한 채우기
        count += N / 5;
        N %= 5;

        // 남은 설탕을 3킬로그램 봉지로 채우기
        while (N % 3 != 0 && count > 0) {
            N += 5; // 5킬로그램 봉지를 하나씩 빼면서 3킬로그램 봉지로 채울 수 있는지 확인
            count--;
        }
        count += N / 3;
        N %= 3;

        if (N == 0) {
            System.out.println(count);
        } else {
            System.out.println("-1");
        }

        scanner.close();
    }
}