package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 친구
 */
public class A1058_2 {
    static int n;
    static boolean[] visits;
    static List<Integer>[] list;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                if(s.charAt(j-1) == 'Y') {
                    list[i].add(j);
                };
            }
        }

        int result = 0;
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            List<Integer> ll = list[i];
            visited = new boolean[n+1];
            visited[i] = true;
            for (int j = 0; j < ll.size(); j++) {
                if(!visited[ll.get(j)]){
                    answer[i]++;
                    visited[ll.get(j)] = true;
                }
                List<Integer> lll = list[ll.get(j)];
                for (int k = 0; k < lll.size(); k++) {
                    if(!visited[lll.get(k)]){
                        visited[lll.get(k)] = true;
                        answer[i]++;
                    }
                }
            }
            result = Math.max(result, answer[i]);
        }
        System.out.println(result);
    }
}
