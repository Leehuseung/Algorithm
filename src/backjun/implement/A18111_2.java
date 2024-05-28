package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 마인크래프트
 */
public class A18111_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int min = 0;
        int max = 0;

        int time = Integer.MAX_VALUE;
        int high = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }




        loop1:
        for (int i = 0; i <= max; i++) {
            int timeDraft = 0;
            int inven = B;

            int[][] copy = new int[map.length][map[0].length]; // 복사할 배열

            for (int t = 0; t < map.length; t++) {
                copy[t] = Arrays.copyOf(map[t], map[t].length);
            }

            //먼저 캔다.
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(i < copy[j][k]) {
                        inven += (copy[j][k] - i);
                        timeDraft += (copy[j][k] - i) * 2;
                        copy[j][k] = i;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(i > copy[j][k]) {
                        inven -= (i - copy[j][k]);
                        timeDraft += (i - copy[j][k]);
                        if(inven < 0) continue loop1;
                    }
                }
            }

            if(time >= timeDraft){
                time = timeDraft;
                high = i;
            }

        }

        System.out.println(time + " " + high);
    }
}
