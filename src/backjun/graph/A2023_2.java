package backjun.graph;

import java.util.Scanner;

/**
 * 신기한 소수
 */
public class A2023_2 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0);
    }

    private static void dfs(int sum, int depth) {
        if(depth == N) System.out.println(sum);
        if(depth != 0) sum *= 10;
        for (int i = 1; i <= 9; i++) {
            int dSum = sum + i;
            if(isPrime(dSum))
                dfs(sum + i, depth+1);
        }
    }

    static boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
