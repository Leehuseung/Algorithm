package backjun.string;

import java.util.Scanner;

/**
 * 그룹 단어 체커
 */
public class A1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isGroupWord(scanner.next())) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char prev = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            if (prev != current) {
                if (visited[current - 'a']) {
                    return false;
                } else {
                    visited[prev - 'a'] = true;
                    prev = current;
                }
            }
        }

        return true;
    }
}