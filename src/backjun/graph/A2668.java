package backjun.graph;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 숫자 고르기
 */
public class A2668 {
    static List<Integer> answer;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = new ArrayList<>();
        int N = sc.nextInt();
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(dfs(i, i)){
                visited[i] = true;
                answer.add(i);
            };
        }

        Collections.sort(answer);
        bw.write(answer.size()+"\n");
        for (Integer integer : answer) {
            bw.write(integer+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int start, int k) {
        int t = arr[k];
        if(visited[t]) return false;
        visited[t] = true;
        if(t == start) return true;

        if(dfs(start, t)) {
            answer.add(t);
            return true;
        } else {
            visited[t] = false;
            return false;
        }
    }
}