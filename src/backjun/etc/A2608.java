package backjun.etc;

import java.util.Scanner;

public class A2608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T;
        int total = 0;
        for(int i = 0 ; i < 2; i++){
            T = sc.nextLine();
            String[] numArr1 = T.split("");
            total += convertNum(numArr1);
        }

        System.out.println(total);

        String numToStrung = covertString(total);

        System.out.println(numToStrung);
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

    public static int convertNum(String[] numArr){
        int total = 0;
        for (int i = 0; i < numArr.length; i++) {
            String a = numArr[i];
            if (i == numArr.length - 1) {
                total += mappingString(a);
            } else {
                if(mappingString(numArr[i]) < mappingString(numArr[i+1])){
                    total += (mappingString(numArr[i+1]) - mappingString(numArr[i]));
                    i++;
                } else {
                    total += mappingString(numArr[i]);
                }
            }
        }
        return total;
    }

    public static String covertString(int num) {
        String returnString = "";
        //1000자리
        int M = num / 1000;

        num = num - (M * 1000);
        //100자리
        int C = num / 100;

        num = num - (C * 100);
        //10자리
        int X = num / 10;

        num = num - (X * 10);
        //1자리
        int I = num;


        for (int i = 0; i < M; i++) {
            returnString += "M";
        }

        if (C == 9) {
            returnString += "CM";
        } else if(C < 9 && C > 5){
            C = C - 5;
            returnString += "D";
            for(int i = 0; i < C; i++){
                returnString += "C";
            }
        } else if(C == 5) {
            returnString += "D";
        }else if (C == 4) {
            returnString += "CD";
        } else {
            for (int i = 0; i < C; i++) {
                returnString += "C";
            }
        }

        if (X == 9) {
            returnString += "XC";
        } else if(X < 9 && X > 5){
            X = X - 5;
            returnString += "L";
            for(int i = 0; i < X; i++){
                returnString += "X";
            }
        } else if(X == 5) {
            returnString += "L";
        } else if(X == 4){
            returnString += "XL";
        } else {
            for(int i = 0; i < X; i++){
                returnString += "X";
            }
        }

        if (I == 9) {
            returnString += "IX";
        } else if(I < 9 && I > 5){
            I = I - 5;
            returnString += "V";
            for(int i = 0; i < I; i++){
                returnString += "I";
            }
        } else if(I == 5) {
            returnString += "V";
        } else if(I == 4){
            returnString += "IV";
        } else {
            for(int i = 0; i < I; i++){
                returnString += "I";
            }
        }

        return returnString;
    }

}
