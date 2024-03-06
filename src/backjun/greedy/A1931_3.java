package backjun.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 회의실 배정
 */
public class A1931_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();
            time[i][1] = in.nextInt();
        }
        int answer = 0;

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int end = time[0][1];
        answer++;

        for (int i = 1; i < N; i++) {
            int[] nextInfo = time[i];
            int nextStart = nextInfo[0];
            int nextEnd = nextInfo[1];
            if(end <= nextStart){
                end = nextEnd;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
