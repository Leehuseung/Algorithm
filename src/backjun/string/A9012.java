package backjun.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괄호
 */
public class A9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        a:
        for (int i = 0; i < T; i++) {
            String PS = br.readLine();
            int count_open = 0;
            int count_close = 0;

            for (int j = 0; j < PS.length(); j++) {
                char ch = PS.charAt(j);
                if (ch == '(') {
                    count_open++;
                } else if (ch == ')') {
                    count_close++;
                }

                if (count_close > count_open) {
                    System.out.println("NO");
                    continue a;
                }
            }

            if (count_open == count_close && PS.charAt(PS.length() - 1) == ')') {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}
