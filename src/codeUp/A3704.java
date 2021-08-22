package codeUp;

import java.util.Scanner;

public class A3704 {
    static int[] memo = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        System.out.println(recursive(k));
    }


    private static int recursive(int k) {
        if(memo[k] != 0){
            return memo[k];
        }

        memo[k] = (recursive(k-3) + recursive(k-2) + recursive(k-1)) % 1000;
        return memo[k];
    }
}