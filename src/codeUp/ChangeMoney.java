package codeUp;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        int count = 0;

        int[] arr = new int[]{50000,10000,5000,1000,500,100,50,10};

        for (int i = 0; i < arr.length; i++) {
            if(num >= arr[i]){
                int an = num / arr[i];
                count += an;
                num -= an * arr[i];
            }
        }
        System.out.println(count);
    }
}
