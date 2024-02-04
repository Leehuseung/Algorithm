package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 소트 게임
 */
public class A1327 {
    static int N,K;
    static char[] arr, copy;
    static String startStr, answerStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
        arr = br.readLine().replace(" ", "").toCharArray();
        copy = Arrays.copyOf(arr, N);
        Arrays.sort(arr);
        answerStr = new String(arr);
        startStr = new String(copy);
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<Strint> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(startStr);

        queue.add(new Strint(startStr,0));

        while(!queue.isEmpty()) {
            Strint s = queue.poll();
            if(s.str.equals(answerStr)) {
                return s.cnt;
            }
            for (int i = 0; i <= N-K; i++) {
                //s.str 을 i번째에서 K만큼 뒤집는다.
                StringBuilder sb = new StringBuilder();
                sb.append(s.str, 0, i);

                // i는 시작값
                for (int j = i+K-1; j >= i ; j--) {
                    sb.append(s.str.charAt(j));
                }
                sb.append(s.str.substring(i+K));
                String ss = sb.toString();
                if(set.contains(ss)) continue;
                set.add(ss);
                queue.add(new Strint(ss, s.cnt+1));
            }
        }
        return -1;
    }
    private static class Strint{
        String str;
        int cnt;
        public Strint(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
