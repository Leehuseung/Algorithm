package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장 가까운 세 사람의 심리적 거리
 */
public class A20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            String[] arr = s.split(" ");
            int cnt = Integer.MAX_VALUE;

            if(arr.length > 32){
                System.out.println(0);
                continue;
            }

            if (arr.length == 1) {
                cnt = 0;
            } else if (arr.length == 2) {
                cnt = getCnt(arr[0], arr[1]);
            } else {
                for (int j = 0; j < arr.length; j++) {
                    for (int l = j+1; l < arr.length; l++) {
                        for (int m = l+1; m < arr.length; m++) {
                            int dist = getCnt(arr[j], arr[l])
                                     + getCnt(arr[l], arr[m])
                                     + getCnt(arr[j], arr[m]);
                            cnt = Math.min(cnt, dist);
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int getCnt(String s, String ss) {
        return (s.charAt(0) == ss.charAt(0) ? 0 : 1)
             + (s.charAt(1) == ss.charAt(1) ? 0 : 1)
             + (s.charAt(2) == ss.charAt(2) ? 0 : 1)
             + (s.charAt(3) == ss.charAt(3) ? 0 : 1);
    }
}
