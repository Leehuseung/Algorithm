package codeUp;

import java.util.Scanner;

public class A1904 {

    public static int b = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        b = sc.nextInt();
        recursive(a);
    }

    public static void recursive(int a){
        if(a > b){
            return;
        } else if (a % 2 == 1){
            System.out.print(a+" ");
        }

        recursive(a+1);
    }
}
