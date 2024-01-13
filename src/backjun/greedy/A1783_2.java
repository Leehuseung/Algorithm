package backjun.greedy;

import java.util.Scanner;

/**
 * 병든 나이트
 */
public class A1783_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        if (N == 1){
            System.out.println(N);
            return;
        }
        if(N == 2) {
            int k = M/2 + (M % 2 == 1 ? 1 : 0);
            System.out.println(Math.min(k,4));
            return;
        }
        if(M < 7){
            System.out.println(Math.min(4,M));
            return;
        }
        System.out.println(M-2);
    }
}
