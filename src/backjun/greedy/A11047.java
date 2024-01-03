package backjun.greedy;

import java.util.Scanner;

/**
 * 동전 0
 */
public class A11047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] coin = new int[N];

        for(int i = 0; i < N; i++) {
            coin[i] = in.nextInt();
        }

        int answer = 0;
        for (int i = coin.length - 1; i >= 0 ; i--) {
            int c = coin[i];
            while(K >= c) {
                K -= c;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
