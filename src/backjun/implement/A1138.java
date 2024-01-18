package backjun.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 한 줄로 서기
 */
public class A1138 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] tall = new int[n+1];
        List<Integer> ans = new ArrayList<>();

        for(int i=1; i<=n; i++) tall[i] = scan.nextInt();

        for(int i=n; i>=1; i--) ans.add(tall[i], i);

        for(int k : ans) System.out.print(k + " ");
    }
}
