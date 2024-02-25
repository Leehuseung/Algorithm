package backjun.greedy;

import java.util.Scanner;

/**
 * 병든 나이트
 */
public class A1783_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int result = 0;
        if(N == 1){
            result = 1;
        }else if(N == 2){
            result = Math.min(4, (M-1)/2+1);
        }else{
            if(M < 7) {
                result = Math.min(4,M);
            } else {
                result = M - 2;
            }
        }
        System.out.println(result);
    }
}
