package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * N-Queen
 */
public class A9663 {

    static int[] arr;
    static int N;
    static int de = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        arr = new int[N];
        dfs(0);
        System.out.println(de);
    }
    public static void dfs(int depth) {
         if(depth == N) {
             de++;
             return;
         }
        loop:
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            for (int j = 0; j < depth; j++) {
                if(arr[j] == arr[depth]){
                    continue loop;
                }
                if(Math.abs(j-depth) == Math.abs(arr[j]-arr[depth])){
                    continue loop;
                }
            }
            dfs(depth+1);
        }
    }
}