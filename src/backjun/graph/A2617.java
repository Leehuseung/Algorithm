package backjun.graph;


import java.util.ArrayList;
import java.util.Scanner;


/**
 * 구슬 찾기
 */
public class A2617 {
    static int aim = 0;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        aim = (N+1)/2;
        int M = in.nextInt();
        ArrayList<Integer>[] parentInfo = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            parentInfo[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] childInfo = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            childInfo[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            Integer s = in.nextInt();
            Integer e = in.nextInt();
            parentInfo[s].add(e);
            childInfo[e].add(s);
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            int sum = dfs(parentInfo, i);
            if(sum >= aim) result++;
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            int sum = dfs(childInfo, i);
            if(sum >= aim) result++;
        }

        System.out.println(result);
    }


    private static int dfs(ArrayList<Integer>[] info, int i) {
        visit[i] = true;
        ArrayList<Integer> list = info[i];
        int sum = 0;
        for (int j = 0; j < list.size(); j++) {
            if(!visit[list.get(j)]){
                visit[list.get(j)] = true;
                sum += dfs(info, list.get(j))+1;
            }
        }
        return sum;
    }
}