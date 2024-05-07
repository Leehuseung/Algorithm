package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1
 */
public class A4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s=br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int answer = 0;
            int k = 1;
            int cnt = 1;
            while((k = k % n) != 0) {
                cnt++;
                k = k * 10 + 1;
            }
            System.out.println(cnt);
        }
    }
}
