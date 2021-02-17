package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class A11256 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int caseNum = sc.nextInt();

        for (int i = 0; i < caseNum; i++) {
            int candyCnt = sc.nextInt();
            int f = sc.nextInt();

            int[] arr = new int[f];
            for (int j = 0; j < f; j++) {
                arr[j] = sc.nextInt() * sc.nextInt();
            }

            Arrays.sort(arr);

            int answer = 0;
            for (int j = arr.length-1 ; j >= 0; j--) {
                if(candyCnt > 0){
                    answer++;
                    candyCnt -= arr[j];
                }
            }
            System.out.println(answer);
        }
    }
}
