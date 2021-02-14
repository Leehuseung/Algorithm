package backjun.greedy;

import java.util.Scanner;

public class A12782 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int forNum = sc.nextInt();

        for (int i = 0; i < forNum; i++) {
            String[] a = sc.next().split("");
            String[] b = sc.next().split("");

            int zeroCount = 0;
            int oneCount = 0;

            for (int j = 0; j < a.length; j++) {
                if(!a[j].equals(b[j])){
                    if(b[j].equals("0")){
                        zeroCount++;
                    } else {
                        oneCount++;
                    }
                }
            }
            System.out.println(Math.max(zeroCount,oneCount));
        }
    }
}
