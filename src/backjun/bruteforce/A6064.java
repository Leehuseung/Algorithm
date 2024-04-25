package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카잉 달력
 */
public class A6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken())-1;
            int targetY = Integer.parseInt(st.nextToken())-1;
            int tempY = targetY;
            int result = targetX;

            boolean check = false;
            int t = 0;
            while(t <= N){
                int na = targetX % N; // 1
                if(na == targetY){
                    check = true;
                    break;
                }
                targetX = targetX + M; // 13
                result += M;
                t++;
            }

            if(check) {
                System.out.println(result+1);
            } else {
                System.out.println(-1);
            }



        }
    }
}
