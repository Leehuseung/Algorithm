package backjun.koi;

import java.util.Arrays;
import java.util.Scanner;

public class A2587 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        int total = 0;

        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            total += num;
        }
        int average = total/5;

        Arrays.sort(arr);


        System.out.println(average);
        System.out.println(arr[2]);
    }
}
