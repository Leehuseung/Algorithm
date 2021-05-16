package codeUp;

import java.util.Scanner;

public class A1902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = Integer.parseInt(sc.nextLine());

        System.out.println(factorial(n));

    }

    private static int factorial(int n) {
        if(n == 1){
            return n;
        }

        System.out.println(n);

        return factorial(n-1);
    }
}
