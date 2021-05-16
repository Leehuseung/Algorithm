package codeUp;

import java.util.Scanner;

public class A1953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
        factorial(1,n);
    }

    private static void factorial(int now,int n) {

        if(now > n){
            return;
        }

        printStar(1,now);

        System.out.println();

        factorial(now+1,n);
    }

    private static void printStar(int now,int n){
        System.out.print("*");

        if(now == n){
            return;
        }

        printStar(now+1,n);
    }
}
