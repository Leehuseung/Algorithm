package codeUp;

import java.math.BigInteger;
import java.util.Scanner;

public class A1916 {

    static BigInteger[] memo = new BigInteger[201];

    public static void main(String[] args) {
        memo[0] = BigInteger.valueOf(0);
        memo[1] = BigInteger.valueOf(1);
        memo[2] = BigInteger.valueOf(1);

        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        System.out.println(recursive(k).remainder(BigInteger.valueOf(10009)));

    }

    public static BigInteger recursive(int param){

        if(memo[param] != null){
            return memo[param];
        }

        memo[(int) param] = recursive(param-2).add(recursive(param-1));

        return memo[(int) param];
    }
}
