package programmers.lv0;

import java.util.Arrays;

/**
 * Lv.0 정수를 나선형으로 배치하기
 */
public class SpiralArrangementOfIntegers {
    public static int[][] solution(int n) {
        int[][] answer = new int [n][n];

        int max = n * n +1;
        int cnt = 1;
        int depth = 0;
        tt :
        while (true) {
            //오른쪽
            for (int i = depth; i < n - depth; i++) {
                if (answer[depth][i] == 0) {
                    answer[depth][i] = cnt;
                    cnt++;
                    if(cnt == max) break tt;
                }
            }

            //아래
            for (int i = depth; i < n; i++) {
                if (answer[i][n-depth-1] == 0) {
                    answer[i][n-depth-1] = cnt;
                    cnt++;
                    if(cnt == max) break tt;
                }
            }

            //왼쪽
            for (int i = n-1-depth; i >= depth; i--) {
                if (answer[n-depth-1][i] == 0) {
                    answer[n-depth-1][i] = cnt;
                    cnt++;
                    if(cnt == max) break tt;
                }
            }


            //위로
            for (int i = n-1-depth; i >= depth; i--) {
                if (answer[i][depth] == 0) {
                    answer[i][depth] = cnt;
                    cnt++;
                    if(cnt == max) break tt;
                }
            }
            depth++;
        }



        return answer;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }

}
