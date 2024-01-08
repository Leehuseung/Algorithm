package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 블로그2
 */
public class A20365 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String problem = br.readLine();

        int blueCnt = 0;
        int redCnt = 0;

        char[] arr = problem.toCharArray();
        for (int i = 0; i < n; i++) {
            if(arr[i] == 'B'){
                blueCnt++;
                if(i != 0 && arr[i-1] == 'B'){
                    blueCnt--;
                }
            } else if(arr[i] == 'R') {
                redCnt++;
                if(i != 0 && arr[i-1] == 'R'){
                    redCnt--;
                }
            }
        }
        int result = blueCnt > redCnt ? 1 + redCnt : 1 + blueCnt;
        System.out.println(result);
    }
}
