package codeUp;

import java.util.Scanner;

public class A1928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = Integer.parseInt(sc.nextLine());

        recursion(n);
    }

    private static void recursion(int n) {
        System.out.println(n);
        if(n == 1){
            return;
        }
        //짝수이면
        if(n % 2 == 0){
            n = n / 2;
        //홀수이면
        } else {
            n = 3 * n + 1;
        }

        recursion(n);

    }
}
