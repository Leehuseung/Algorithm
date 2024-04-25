package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * N과 M (9)
 */
public class A15663 {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;
    static boolean[] vistied;
    static Set set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[n];
        vistied = new boolean[n];
        set = new HashSet();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = -1;
        for (int i = 0; i < n; i++) {
            if(!vistied[i] && before != arr[i]) {
                answer[depth] = arr[i];
                vistied[i] = true;
                before = arr[i];
                dfs(depth+1);
                vistied[i] = false;
            }
        }
    }
}
