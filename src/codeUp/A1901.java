package codeUp;

import java.util.Scanner;

public class A1901 {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Integer n = Integer.parseInt(sc.nextLine());

    factorial(1,n);

}

    private static void factorial(int now,int n) {
        if(now > n){
            return;
        }

        System.out.println(now++);

        factorial(now,n);
    }
}
