package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 에너지 드링크
 */
public class A20115 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double[] arr = new double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextDouble();
        }

        Arrays.sort(arr);
        double result = arr[arr.length-1];

        for (int i = 0; i < arr.length-1; i++) {
            result += arr[i]/2;
        }

        System.out.println(result);

    }
}
