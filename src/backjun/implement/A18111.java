package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트
 */
public class A18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        int high = 0;
        int time = Integer.MAX_VALUE;
        loop:
        for (int i = 0; i <= max; i++) {
            //i 로 땅 고르기를 시작한다.
            int cloneB = B;
            int cloneTime = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int h = map[j][k];
                    //더 높으면 깎아야한다.
                    if (h > i) {
                        cloneB += (h - i);
                        cloneTime += 2 * (h - i);
                    // 작으면 채워 넣어야 한다.
                    } else if (h < i) {
                        cloneB -= (i - h);
                        cloneTime += (i - h);
                    }
                }
            }

            if(cloneB < 0) continue loop;

            if(high <= i && time >= cloneTime) {
                high = i;
                time = cloneTime;
            }
        }

        System.out.println(time + " " + high);
    }
}

/*
3 4 0
64 64 64 64
64 64 64 64
64 64 64 63

3 4 99
0 0 0 0
0 0 0 0
0 0 0 1

1 3 68
0 0 1

3 4 11
29 51 54 44
22 44 32 62
25 38 16 2

4 4 36
15 43 61 21
19 33 31 55
48 63 1 30
31 28 3 8
 */