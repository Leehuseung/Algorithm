package backjun.string;

import java.util.*;

/**
 * 30
 */
public class A10610 {
    static String maxMultipleOf30(String N) {
        char[] digits = N.toCharArray();

        // 숫자들의 총 합 구하기
        int sum = 0;
        for (char digit : digits) {
            sum += (digit - '0');
        }

        // 내림차순으로 정렬
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder();

        // 30의 배수인지 확인
        if (sum % 3 == 0 && digits[0] == '0') {
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
            return sb.toString();
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        System.out.println(maxMultipleOf30(N));
    }
}