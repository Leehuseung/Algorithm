package codeUp;

import java.util.Scanner;

public class A1930 {

    static int total = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k,n;

        while(sc.hasNextInt()) {
            total = 0;
            k = sc.nextInt();
            n = sc.nextInt();

            calc(k,n);
            System.out.println(total);
        }
    }

    public static void calc(int k, int n){
        if(k == 0){
            total += n;
            return;
        }
        for(int i = 1 ; i <= n; i++){
            calc(k-1,i);
        }
    }
}
