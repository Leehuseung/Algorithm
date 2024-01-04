package backjun.greedy;

import java.util.Scanner;

/**
 * 병든 나이트
 */
public class A1783 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        if (N == 1){
            System.out.println(N);
        } else if (N == 2) {
            System.out.println(Math.min(4,(M+1) / 2));
        } else if (M < 7) {
            System.out.println(Math.min(4,M));
        } else {
            System.out.println(M - 2);
        }
    }
}
