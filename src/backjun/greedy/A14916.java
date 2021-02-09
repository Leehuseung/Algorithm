package backjun.greedy;

import java.util.Scanner;

public class A14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if(num == 1 || num == 3){
            System.out.println(-1);
            return;
        }

        int two = 0;
        int n = 0;

        int five = num / 5;     //5 의 값
        n = num % 5;        //5 로 나눈나머지

        if(n == 1){
          five--;
          two = 3;
        } else if(n == 3){
            five--;
            two = 4;
        } else {
            two = n / 2;
        }
        System.out.println(five + two);
    }
}
