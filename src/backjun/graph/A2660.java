package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 회장뽑기
 */
public class A2660 {
    static List<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken()); // 회원 수
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < n; i++) {
            visited = new boolean[n+1];

        }

        int min = Integer.MAX_VALUE;
        for (int i: answer){
            min = Math.min(i, min);
        }
        int cnt = 0;
        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(answer[i] == min) {
                cnt++;
                answerList.add(i);
            }
        }
        Collections.sort(answerList);
        System.out.print(min + " " + cnt);
        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }
}
