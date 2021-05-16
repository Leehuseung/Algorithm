package codeUp;

import java.util.Scanner;

public class A1905 {
    static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer n = Integer.parseInt(sc.nextLine());

        factorial(1,n);
        System.out.println(total);
    }
    private static void factorial(int now,int n) {

        if(now > n){
            return;
        }

        total += now;

        factorial(now+1,n);
    }
}

