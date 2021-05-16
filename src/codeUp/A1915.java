package codeUp;

import java.util.Scanner;

public class A1915 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Integer n = Integer.parseInt(sc.nextLine());
            System.out.println(recursion(n));
    }

    private static int recursion(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return recursion(n-1) + recursion(n-2);
    }
}

