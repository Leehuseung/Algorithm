package backjun.implement;

import java.util.Scanner;

/**
 * 기적의 매매법
 */
public class A20546 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cash = in.nextInt();
        int[] arr = new int[14];
        for (int i = 0; i < 14; i++) {
            arr[i] = in.nextInt();
        }
        
        //준현
        int bnpCnt = 0; //주식수
        int bnpCash = cash; //돈
        for (int i = 0; i < arr.length; i++) {
            int cc = bnpCash / arr[i];
            if(cc > 0){
                bnpCnt += cc;
                bnpCash -= cc * arr[i];
            }
        }
        int bnpTotal = bnpCash + (bnpCnt * arr[arr.length-1]); //

        //준현
        int timingCnt = 0; //주식수
        int timingCash = cash; //돈
        int plusCnt = 0;
        int minusCnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]){
                plusCnt++;
                minusCnt = 0;
            } else if (arr[i] < arr[i-1]){
                plusCnt = 0;
                minusCnt++;
            } else {
                plusCnt = 0;
                minusCnt = 0;
            }
            if(plusCnt >= 3){
                timingCash += arr[i] * timingCnt;
                timingCnt = 0;
            }
            if(minusCnt >= 3){
                int cc = timingCash / arr[i];
                if(cc > 0){
                    timingCnt += cc;
                    timingCash -= cc * arr[i];
                }
            }

        }
        int timingTotal = timingCash + (timingCnt * arr[arr.length-1]); //

        if(bnpTotal == timingTotal){
            System.out.println("SAMESAME");
            return;
        }
        if(bnpTotal > timingTotal){
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}
