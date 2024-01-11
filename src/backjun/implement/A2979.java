package backjun.implement;

import java.util.Scanner;

/**
 * 트럭 주차
 */
public class A2979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] total = new int[101];

        int[][] arr = new int[3][];
        for (int i = 0; i < 3; i++) {
            arr[i] = new int[2];
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = arr[i][0]; j <= arr[i][1]-1 ; j++) {
                total[j]++;
            }
        }

        int result = 0;
        for (int i = 0; i < total.length; i++) {
            if(total[i] == 1){
                result += A;
            } else if (total[i] == 2) {
                result += (B * 2);
            } else if (total[i] == 3) {
                result += (C * 3);
            }
        }
        System.out.println(result);
    }
}
