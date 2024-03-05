package backjun.greedy;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 단어 수학
 */
public class A1339_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] arr = new String[n];
        int[] adds = new int[26];
        for(int i=0; i<n; i++) arr[i] = sc.next();
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int k = (int) Math.pow(10, chars.length-j-1);
                int t = chars[j]-'A';
                adds[t] += k;
            }
        }

        int max = 9;
        Arrays.sort(adds);

        for (int i = adds.length-1; i >= 0; i--) {
            if(adds[i] != 0) {
                answer += adds[i] * max;
                max--;
            }
        }

        System.out.println(answer);
    }
}
