package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 점프 게임
 */
public class A15558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[2][n+1];

        int[][] arr = new int[2][n+1];

        for (int i = 0; i < 2; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j+1] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,1});
        visited[0][1] = true;
        int last = 1;
        int queueSize = 1;

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int jul = info[0];
            int kan = info[1];
            // 앞으로 갈 때
            if(kan+1 > n) {
                System.out.println(1);
                return;
            }
            if(kan+1 > last && arr[jul][kan+1] == 1 && !visited[jul][kan+1]){
                visited[jul][kan+1] = true;
                queue.add(new int[]{jul, kan+1});
            }
            // 뒤로 갈 때
            if(kan-1 > last && arr[jul][kan-1] == 1 && !visited[jul][kan-1]){
                visited[jul][kan-1] = true;
                queue.add(new int[]{jul, kan-1});
            }
            // 0에서 넘어 갈 때
            if(kan+k > n) {
                System.out.println(1);
                return;
            }
            if(jul == 0) {
                if(kan+k > last && arr[1][kan+k] == 1 && !visited[1][kan+k]){
                    visited[1][kan+k] = true;
                    queue.add(new int[]{1, kan+k});
                }
            } else {
                if(kan+k > last && arr[0][kan+k] == 1 && !visited[0][kan+k]){
                    visited[0][kan+k] = true;
                    queue.add(new int[]{0, kan+k});
                }
            }

            queueSize--;
            if(queueSize == 0) {
                last++;
                queueSize = queue.size();
            }
        }

        System.out.println(0);
    }
}
