package backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 소트 게임
 */
public class A1327_2 {
    static int N,K;
    static char[] arr, copy;
    static String startStr, answerStr;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
        arr = br.readLine().replace(" ", "").toCharArray();
        copy = Arrays.copyOf(arr, N);
        set = new HashSet<>();
        Arrays.sort(arr);
        answerStr = new String(arr);
        startStr = new String(copy);
        set.add(startStr);
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<String> queue = new LinkedList<>();
        //start를 큐에 넣는다.
        queue.add(startStr);
        //큐가 비어있지 않으면
        int qs = 1;
        int cnt = 0;
        while(!queue.isEmpty()) {
            String s = queue.poll();
            qs--;
            if(s.equals(answerStr)) return cnt;

            for (int i = 0; i <= answerStr.length()-K; i++) {
                String newS = change(s, i);
                if(!set.contains(newS)) {
                    set.add(newS);
                    queue.add(newS);
                }
            }

            if(qs == 0) {
                cnt++;
                qs = queue.size();
            }
        }

        return -1;
    }

    private static String change(String s, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) sb.append(s.charAt(j));
        for (int j = i + K - 1; j >= i; j--) sb.append(s.charAt(j));
        for (int j = i + K; j < s.length(); j++) sb.append(s.charAt(j));
        return sb.toString();
    }
}
