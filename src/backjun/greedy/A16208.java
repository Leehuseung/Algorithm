package backjun.greedy;

import java.util.Scanner;

public class A16208 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        long[] arr = new long[len];

        long total = 0;

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        long num = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            total += num * arr[i+1];
            num = num + arr[i+1];
        }

        System.out.println(total);
    }
}
