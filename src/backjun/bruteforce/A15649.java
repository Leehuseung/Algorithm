package backjun.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N과 M (1)
 */
public class A15649 {
    static int N;
    static int M;
    static List<Integer> list;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list = new ArrayList<>();
            list.add(i);
            backtrack(i, 1);
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void backtrack(int now, int depth) throws IOException {
        if (visited[now]) return;
        if (depth > M) return;
        if (depth == M) {
            for (Integer integer : list) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }
        visited[now] = true;
        for (int i = 1; i <= N; i++) {
            list.add(i);
            backtrack(i, depth + 1);
            list.remove(list.size() - 1);
        }
        visited[now] = false;
    }
}
