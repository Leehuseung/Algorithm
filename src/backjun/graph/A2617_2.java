package backjun.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 구슬 찾기
 */
public class A2617_2 {
    static int aim = 0;
    static int result = 0;
    static int N;
    static boolean[] visited;
    static int[] answers;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        aim = (N+1)/2;
        int M = in.nextInt();
        result = 0;
        visited = new boolean[N+1];
        answers = new int[N+1];
        ArrayList<Integer>[] parentInfo = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            parentInfo[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] childInfo = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            childInfo[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            Integer s = in.nextInt();
            Integer e = in.nextInt();
            parentInfo[s].add(e);
            childInfo[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i, i, parentInfo);
        }
        for (int i = 1; i <= N; i++) if (aim <= answers[i]) result++;


        answers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i, i, childInfo);
        }
        for (int i = 1; i <= N; i++) if (aim <= answers[i]) result++;

        System.out.println(result);
    }

    private static void dfs(int start, int i, ArrayList<Integer>[] ll) {
        visited[i] = true;
        List<Integer> list = ll[i];
        for (Integer integer : list) {
            if(!visited[integer]) {
                answers[start]++;
                visited[integer] = true;
                dfs(start, integer, ll);
            }
        }
    }
}
