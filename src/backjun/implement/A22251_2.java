package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빌런 호석
 */
public class A22251_2 {
    static int[][] arr;
    static int[][] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //입력
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        // a -> b가 되려면 필요한 반전의 수
        arr2 = new int[10][];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = new int[10];
        }

        int N = Integer.parseInt(st.nextToken()); // N층까지 이용
        int K = Integer.parseInt(st.nextToken()); // 자리수K
        int P = Integer.parseInt(st.nextToken()); // 최대 P개 반전
        int X = Integer.parseInt(st.nextToken()); // 현재 X
        arr = new int[10][];
        arr[0] = new int[]{ 1,1,1,0,1,1,1 };
        arr[1] = new int[]{ 0,0,1,0,0,1,0 };
        arr[2] = new int[]{ 1,0,1,1,1,0,1 };
        arr[3] = new int[]{ 1,0,1,1,0,1,1 };
        arr[4] = new int[]{ 0,1,1,1,0,1,0 };
        arr[5] = new int[]{ 1,1,0,1,0,1,1 };
        arr[6] = new int[]{ 1,1,0,1,1,1,1 };
        arr[7] = new int[]{ 1,0,1,0,0,1,0 };
        arr[8] = new int[]{ 1,1,1,1,1,1,1 };
        arr[9] = new int[]{ 1,1,1,1,0,1,1 };

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 7; k++) {
                    if(arr[i][k] != arr[j][k]){
                        arr2[i][j]++;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            result += cntUp(X, i, P, K);
        }

        System.out.println(result);
    }

    private static Integer cntUp(int now, int target, int change, int K) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int nn = now % 10;
            int tt = target % 10;
            now /= 10;
            target /= 10;
            cnt += arr2[nn][tt];
        }
        return cnt <= change ? 1 : 0;
    }
}