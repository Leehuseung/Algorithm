package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DSLR
 */
public class A9019 {
    static char[] chars = new char[]{'D','S','L','R'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(cal(start, end));
        }
    }

    private static String cal(int start, int end) {
        Queue<Comb> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        for (int i = 0; i < 4; i++) queue.add(new Comb(start, "", chars[i]));

        while(!queue.isEmpty()) {
            Comb comb = queue.poll();
            if(comb.num == end){
                return comb.s;
            }

            for (int i = 0; i < 4; i++) {
                int newCombNum = dslr(comb.num, chars[i]);
                if(!visited[newCombNum]){
                    visited[newCombNum] = true;
                    Comb newComb = new Comb(newCombNum ,comb.s + (chars[i]) ,chars[i]);
                    queue.add(newComb);
                }
            }
        }

        return "";
    }

    static int dslr(int i, char c){
        if(c == 'D') return (2 * i) % 10000;
        else if (c == 'S') return (i == 0) ? 9999 : i - 1;
        else if (c == 'L') return (i % 1000) * 10 + i / 1000;
        else return (i % 10) * 1000 + i / 10;
    }

    static class Comb {
        int num;
        String s;
        char turn;

        public Comb(int num, String s, char turn) {
            this.num = num;
            this.s = s;
            this.turn = turn;
        }
    }
}
