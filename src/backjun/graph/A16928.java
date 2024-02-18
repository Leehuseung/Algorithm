package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뱀과 사다리
 */
public class A16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[101];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        visited[1] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            //각각 주사위 나올 때..
            for (int i = 1; i <= 6; i++) {
                int newNow = now[0] + i;
                if(newNow == 100){
                    System.out.println(now[1]);
                    return;
                } else if (newNow > 100){
                    continue;
                }
                if(map.containsKey(newNow)) newNow = map.get(newNow);
                if(!visited[newNow]){
                    visited[newNow]=true;
                    queue.add(new int[]{newNow, now[1]+1});
                }
            }
        }
    }
}
