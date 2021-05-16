package codeUp;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = Integer.parseInt(sc.nextLine());

        System.out.println(factorial(n));

    }

    private static int factorial(int n) {
        if(n == 1){
            return n;
        }
        return n * factorial(n-1);
    }
}
