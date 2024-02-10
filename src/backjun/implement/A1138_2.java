package backjun.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 한 줄로 서기
 */
public class A1138_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] tall = new int[n+1];
        for(int i=1; i<=n; i++) tall[i] = scan.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = n ;i >= 1; i--) {
            if(tall[i] <= list.size()){
                list.add(tall[i], i);
                continue;
            }
            list.add(i);
        }
        for(int k : list) System.out.print(k + " ");
    }
}
