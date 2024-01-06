package backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 신입 사원
 */
public class A1946 {
    static int T, num;
    static int[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            num = Integer.parseInt(br.readLine());
            score = new int[num][2];

            for (int j = 0; j < num; j++) {
                String[] str = br.readLine().split(" ");
                score[j][0] = Integer.parseInt(str[0]);
                score[j][1] = Integer.parseInt(str[1]);
            }

            Arrays.sort(score, (o1, o2) -> o1[0] - o2[0]);

            int result = num;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < score.length; j++) {
                min = Math.min(min, score[j][1]);
                if(score[j][1] > min){
                    result--;
                }
            }
            System.out.println(result);
        }
    }
}
