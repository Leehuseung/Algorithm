package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M(1)
 */
public class A15649_3 {
    static boolean[] visited;
    static int[] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        backtracking(0);
    }

    private static void backtracking(int depth) {
        if(depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth]= i+1;
                backtracking(depth+ 1);
                visited[i] = false;
            }
        }
    }
}
