package backjun.greedy;

import java.util.Scanner;

/**
 * 두 배 더하기
 */
public class A12931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        Integer[] arr = new Integer[length];

        for(int i=0;  i<length ; i++) arr[i] = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1){
                arr[i]--;
                sum++;
                if(isFlag(arr)) break;
                i = 0;
            }

            if(i == arr.length-1){
                if(isFlag(arr)) break;
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = arr[j]/2;
                }
                sum++;
                i = -1;
            }
        }
        System.out.println(sum);
    }

    private static boolean isFlag(Integer[] arr) {
        boolean flag = true;
        for (Integer integer : arr) {
            if (integer != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
