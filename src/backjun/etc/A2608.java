package backjun.etc;

import java.util.Scanner;

public class A2608 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String T;
//        T = sc.nextLine();


        String T = "MMCDXCIII";

        String[] numArr1 = T.split("");

        int total = 0;

        for (int i = 0; i < numArr1.length; i++) {
            String a = numArr1[i];
            if (i == 0 || i == numArr1.length - 1 ) {
                total += mappingString(a);
            } else {
                if(mappingString(numArr1[i]) < mappingString(numArr1[i+1])){
                    total += (mappingString(numArr1[i+1]) - mappingString(numArr1[i]));
                    i++;
                } else {
                    total += mappingString(numArr1[i]);
                }
            }
            System.out.println(total);
        }
        System.out.println(total);
    }

    public static int mappingString(String word){
        int returnNum = 0;
        switch (word){
            case "I" :
                returnNum = 1;
                break;
            case "V" :
                returnNum = 5;
                break;
            case "X" :
                returnNum = 10;
                break;
            case "L" :
                returnNum = 50;
                break;
            case "C" :
                returnNum = 100;
                break;
            case "D" :
                returnNum = 500;
                break;
            case "M" :
                returnNum = 1000;
                break;
        }
        return returnNum;
    }

}
