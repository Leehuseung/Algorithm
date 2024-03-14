package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */
public class A1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k,0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int start = info[0];
            int cnt = info[1];
            if(start == n){
                System.out.println(cnt);
                break;
            }
            int a = start - 1;
            if(a > -1 && !visited[a]){
                queue.add(new int[]{a, cnt+1});
                visited[a] = true;
            }
            int m = start + 1;
            if(m <= 100000 && !visited[m]){
                queue.add(new int[]{m, cnt+1});
                visited[m] = true;
            }
            int q = start * 2;
            if(q <= 100000 && !visited[q]) {
                queue.add(new int[]{q, cnt+1});
                visited[q] = true;
            }
        }
    }
}
