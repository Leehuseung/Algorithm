package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부등호
 */
public class A2529 {
    static String[] arr;
    static int n;
    static int[] answer;
    static boolean[] visited;
    static boolean first = false;
    static StringBuilder sbFirst;
    static StringBuilder sbLast;

    public static void main(String[]  args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        visited = new boolean[10];
        answer = new int[arr.length + 1];
        sbFirst = new StringBuilder();
        sbLast = new StringBuilder();

        dfs(0);
        System.out.println(sbLast);
        System.out.println(sbFirst);
    }

    private static void dfs(int depth) {
        if (depth == arr.length + 1) {
            // 검사
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("<")) {
                    if (answer[i] > answer[i + 1]) {
                        return;
                    }
                } else if (arr[i].equals(">")) {
                    if (answer[i] < answer[i + 1]) {
                        return;
                    }
                }
            }

            // 맞으면 출력
            StringBuilder current = new StringBuilder();
            for (int num : answer) {
                current.append(num);
            }

            if (!first) {
                first = true;
                sbFirst.append(current);
            }
            sbLast = new StringBuilder(current);

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
