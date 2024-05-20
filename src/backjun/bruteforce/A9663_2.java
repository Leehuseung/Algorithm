package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N-Queen
 */
public class A9663_2 {

    static int[] arr;
    static boolean[] visited;
    static int N;
    static int de = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        arr = new int[N];
        visited = new boolean[N];
        dfs(0);
        System.out.println(de);
    }
    public static void dfs(int depth) {

        for (int j = 0; j < depth; j++) {
            for (int k = j+1; k < depth; k++) {
                if(j+1-arr[j] == k+1-arr[k]){
                    return;
                }
                if(j+1+arr[j] == k+1+arr[k]){
                    return;
                }
            }
        }

        if(depth == N){
            de++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
