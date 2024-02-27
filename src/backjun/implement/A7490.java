package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

import static java.util.stream.Collectors.toList;

/**
 * 0 만들기
 */
public class A7490 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            comb(1,1,"1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // +, -, ' '
    static void comb(int num, int len, String str){

        if(len == n) {
            if(calculate(str) == 0) {
                sb.append(str+"\n");
            }
            return;
        }

        comb(num+1, len+1, str+ ' ' + (num+1));
        comb(num+1, len+1, str+ '+' + (num+1));
        comb(num+1, len+1, str+ '-' + (num+1));

    }

    static int calculate(String str){
        str = str.replaceAll(" ", "");
        Iterator<Integer> it= Arrays.stream(str.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(toList()).iterator();
        int result = it.next();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '+') {
                result += it.next();
            }else if(str.charAt(i) == '-') {
                result -= it.next();
            }
        }
        return result;

    }
}