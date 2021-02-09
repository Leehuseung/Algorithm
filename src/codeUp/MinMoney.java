package codeUp;

import java.util.Scanner;

public class MinMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int minA = arr[0];
        int minB = arr[3];
        for (int i = 1; i < 3; i++) {
            if(minA > arr[i]){
                minA = arr[i];
            }
        }

        for (int i = 3; i < 5; i++) {
            if(minB > arr[i]){
                minB = arr[i];
            }
        }
        
        int a = minA + minB;
        double b = a * 0.1;
        double c = a + b;
        System.out.println(c);
    }
}
