package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 이어 쓰기 1
 */
public class A1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;	// 자릿수
        int plus = 1;	// 자릿수에 더하는 값
        int num = 10;	// 몇 자릿수 더할지 판단
        int N = Integer.parseInt(bf.readLine());
        for(int i=1; i<=N; i++) {
            // 자릿수 바뀌는 조건 => 10, 100, 1000, 10000, ...
            if(i%num == 0) {
                plus ++;
                num *= 10;
            }
            count += plus;

        }
        System.out.println(count);
        bf.close();
    }
}
