package backjun.greedy;

import java.util.Scanner;

public class A1439 {
    public static void main(String[] args) {
        int one=0, zero=0;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.charAt(0)=='0')	zero++;
        else	one++;

        for (int i = 1; i < s.length(); ++i) {
            if(s.charAt(i)== '0' && s.charAt(i-1) == '1')
                zero++;
            else if(s.charAt(i) == '1' && s.charAt(i-1) == '0')
                one++;
        }
        System.out.println(Math.min(one, zero));
    }
}
