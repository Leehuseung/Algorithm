package codeUp;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 파스칼의 삼각형 2
 */
public class A3702 {

    static BigInteger[][] arr = new BigInteger[51][51];


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        //18389602
        System.out.println(recursive(a,b).remainder(BigInteger.valueOf(100000000)));
    }

    public static BigInteger recursive(int a,int b){

        if(a == 1 || b == 1){
            return BigInteger.valueOf(1);
        }

        if(arr[a][b] != null){
            return arr[a][b];
        }

        arr[a][b] = recursive(a-1,b).add(recursive(a,b-1));

        return arr[a][b];
    }
}
