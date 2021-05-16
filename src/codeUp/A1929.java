package codeUp;

import java.util.Scanner;

public class A1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = Integer.parseInt(sc.nextLine());

        recursion(n);
        System.out.println(n);
    }

    private static void recursion(int n) {
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
        System.out.println(n);
    }
}
