package backjun.greedy;

import java.util.Scanner;

public class A5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        int a = 1000;

        int count = 0;

        num = a - num;

        int[] arr = new int[]{500,100,50,10,5,1};

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
