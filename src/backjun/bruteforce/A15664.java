package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (10)
 */
public class A15664 {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
    }

    private static void dfs(int now, int depth) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = -1;
        for (int i = now; i < n; i++) {
            if(!visited[i] && before != arr[i]){
                visited[i] = true;
                before = arr[i];
                answer[depth] = arr[i];
                dfs(i+1,depth + 1);
                visited[i] = false;
            }
        }
    }
}

