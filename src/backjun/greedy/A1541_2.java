package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 잃어버린 괄호
 */
public class A1541_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String T = bf.readLine();

        StringBuffer sb = new StringBuffer();
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i) != '+' && T.charAt(i) != '-'){
                sb.append(T.charAt(i));
            } else {
                int k = Integer.parseInt(sb.toString());
                sb = new StringBuffer();
                if(flag){
                    sum -= k;
                } else {
                    sum += k;
                }
                if (T.charAt(i) == '-'){
                    flag = true;
                }
            }
        }

        if(flag){
            sum -= Integer.parseInt(sb.toString());
        } else {
            sum += Integer.parseInt(sb.toString());
        }

        System.out.println(sum);
    }
}
