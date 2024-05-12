package backjun.string;

import java.io.IOException;
import java.util.Scanner;

/**
 * IOIOI
 */
public class A5525 {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = Integer.parseInt(sc.nextLine());
       int m = Integer.parseInt(sc.nextLine());
       char[] s = sc.nextLine().toCharArray();
        int result = 0; // 최종 값
        int patternCnt = 0; // `IOI` 패턴 연속 횟수
        for (int i = 1; i < m - 1; i++) {
           if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                   patternCnt++;
                   if (patternCnt == n) {
                           patternCnt--;
                           result++;
                       }
                   i++;
               } else patternCnt = 0;
       }
        System.out.println(result);
    }
}
