package backjun.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long total = 0;
        for (int i = 0; i < N; i++) {
            int price = arr[i] - i;
            if(price > 0){
                total += price;
                continue;
            }
            break;
        }
        System.out.print(total);

    }
}
