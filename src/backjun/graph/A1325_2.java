package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 효율적인 해킹 시간초과..
 */
public class A1325_2 {
    static ArrayList<Integer>[] computers;
    static boolean[] visited;
    static int max;
    static int answer[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = 0;
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        computers = new ArrayList[n + 1];
        visited = new boolean[n+1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i,0);
        }

        for (int i = 1; i <= n ; i++) {
            if(max == answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int i, int depth) {
        if(visited[i]) return;
        depth++;
        visited[i] = true;
        answer[i]++;
        max = Math.max(max, answer[i]);

        for (int n : computers[i]) {
            if (!visited[n]) {
                dfs(n, depth + 1);
            }
        }
        visited[i] = false;
    }
}
