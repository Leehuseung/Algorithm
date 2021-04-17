package backjun.greedy;

import java.util.Scanner;

public class A13413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        System.out.println(T);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            String init = sc.nextLine();
            String aim = sc.nextLine();


            String[] initArr = init.split("");
            String[] aimArr = aim.split("");

            int wNum = 0;
            int bNum = 0;
            for (int j = 0; j < initArr.length; j++) {
                if(initArr[j].equals("W") && !aimArr[j].equals("W")){
                    wNum++;
                } else if (initArr[j].equals("B") && !aimArr[j].equals("B")){
                    bNum++;
                }
            }
            System.out.println("answer : " + Math.max(wNum,bNum));

        }
    }
}

/*
- 위치가 다른것의 개수

- 문자가 다른것의 개수



3
5
WBBWW  W 3 B 2      문자 : 0 위치   W1 B2
WBWBW  W 3 B 2      AN : 1
7
BBBBBBB B 7         문자 : 3      B3
BWBWBWB B 4 W 3     AN : 3
4
WWBB  W 2 B 2       문자 : 1      B2 W1
BBWB  W 1 B 3       AN : 2

 */
