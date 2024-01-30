package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 친구
 */
public class A1058 {
    static int n;
    static List<Integer>[] list;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        answer = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                if(s.charAt(j-1) == 'Y') {
                    list[i].add(j);
                };
            }
        }

        for (int i = 1; i <= n ; i++) {
            List<Integer> l = list[i];
            for (int t : l) {
                answer[i][t] = 1;
                List<Integer> m = list[t];
                for (Integer integer : m) {
                    if (integer != i && integer != t) {
                        answer[i][integer] = 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0 ;
            for (int j = 1; j <= n; j++) {
                sum += answer[i][j];
            }
            result = Math.max(sum, result);
        }
        System.out.println(result);
    }
}
/*
6
NYYNYN
YNYNNN
YYNYNN
NNYNNN
YNNNNY
NNNNYN
 */