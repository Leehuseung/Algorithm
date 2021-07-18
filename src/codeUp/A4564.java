package codeUp;

import java.util.Scanner;

public class A4564 {
    static int[] arr;
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());

        arr = new int[k];
        memo = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] =  Integer.parseInt(sc.nextLine().trim());
        }
        System.out.println(recursive(arr.length-1));;
    }

    private static int isMax(int a, int b){
        return Math.max(a,b);
    }

    private static int recursive(int k) {

        if (k < 0) {
            return 0;
        }
        if(k == 0 ){
            memo[0] = arr[0];
            return memo[0];
        }
        if (k == 1) {
            memo[1] = arr[1] + arr[0];
            return memo[1];
        }
        if(memo[k] != 0){
            return memo[k];
        }

        memo[k] = isMax((arr[k - 1] + recursive(k - 3)) , recursive(k - 2))  + arr[k];

        return memo[k];
    }
}