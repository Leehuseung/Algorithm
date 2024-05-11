package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 암호 만들기
 */
public class A1759 {
    static boolean[] b = new boolean[26];
    static int L;
    static int C;
    static Character[] arr;
    static boolean[] visited;
    static Character[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        b['a' - 'a'] = true;
        b['i' - 'a'] = true;
        b['o' - 'a'] = true;
        b['e' - 'a'] = true;
        b['u' - 'a'] = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[C];
        answer = new Character[L];
        arr = new Character[C];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recursive(0, 0, 0, 0);
        System.out.println(sb.toString());
    }

    private static void recursive(int depth, int ja, int mo, int now) {
        if (depth == L && ja > 1 && mo > 0) {
            for (Character ch : answer) {
                sb.append(ch);
            }
            sb.append("\n");
            return;
        }else if (depth == L){
            return;
        }

        for (int i = now; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                if (b[arr[i] - 'a']) {
                    recursive(depth + 1, ja, mo + 1, i);
                } else {
                    recursive(depth + 1, ja + 1, mo, i);
                }
                visited[i] = false;
            }
        }
    }
}
