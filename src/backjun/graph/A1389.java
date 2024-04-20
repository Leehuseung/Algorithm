package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 케빈 베이컨의 6단계 법칙
 */
public class A1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], n);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            matrix[s-1][e-1] = 1;
            matrix[e-1][s-1] = 1;
        }

        System.out.println(Floyd_Warshall(matrix)+1);
    }

    private static int Floyd_Warshall(int[][] arr) {
        int[] baconNum = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if(arr[j][k] > arr[j][i] + arr[k][i]){
                        arr[j][k] = arr[j][i] + arr[k][i];
                    }
                }
            }
        }

        int minNum = 0;
        for (int i = 0; i < baconNum.length; i++) {
            for (int j = 0; j < baconNum.length; j++) {
                if (i != j) {
                    baconNum[i] += arr[i][j];
                }
            }
            minNum = (baconNum[i] < baconNum[minNum]) ? i : minNum;
        }

        return minNum;
    }

}