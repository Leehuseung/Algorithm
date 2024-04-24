package backjun.graph;

import java.util.Scanner;

/**
 * 리모컨
 */
public class A1107_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();
        int m = scan.nextInt();

        boolean[] broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            int n = scan.nextInt();
            broken[n] = true;
        }
        int result = Integer.MAX_VALUE;
        int start = 100;
        loop:
        for (int i = 0; i <= 999999; i++) {
            String stringI = i + "";
            for (int j = 0; j < stringI.length(); j++) {
                char c = stringI.charAt(j);
                for (int k = 0; k < broken.length; k++) {
                    if(broken[k] && (c - '0') == k){
                        continue loop;
                    }
                }
            }
            result = Math.min(Math.abs(i-target)+ stringI.length(), result);
        }
        result = Math.min(Math.abs(start-target), result);
        System.out.println(result);
    }
}
