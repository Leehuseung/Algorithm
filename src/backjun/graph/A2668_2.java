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
public class A2668_2 {
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

        //여기
        for (int i = 1; i < arr.length; i++) {
            dfs(i, i, new ArrayList<>());
        }

        bw.write(answer.size()+"\n");
        Collections.sort(answer);
        for (Integer integer : answer) {
            bw.write(integer+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int i, int start, ArrayList<Integer> integers) {
        if(start == arr[i]) {
            visited[i] = true;
            integers.add(i);
            answer.addAll(integers);
            return true;
        }
        if(visited[i]) return false;
        visited[i] = true;
        integers.add(i);
        if(!dfs(arr[i], start, integers)) {
            visited[i] = false;
            return false;
        }
        return true;
    }
}