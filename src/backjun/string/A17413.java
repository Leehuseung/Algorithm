package backjun.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 단어 뒤집기 2
 */
public class A17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        boolean isTag = false; // 태그 안에 있는지 여부를 확인하기 위한 플래그

        for (char ch : input.toCharArray()) {
            if (ch == '<') { // '<'가 나오면 태그 시작
                printStack(stack, sb); // 스택에 담긴 단어 출력
                isTag = true;
                sb.append(ch); // '<'는 그대로 출력
            } else if (ch == '>') { // 태그 끝
                isTag = false;
                sb.append(ch); // '>'는 그대로 출력
            } else if (isTag) { // 태그 안에 있는 경우
                sb.append(ch); // 태그는 그대로 출력
            } else if (ch == ' ') { // 공백이 나오면 스택에 담긴 단어 출력
                printStack(stack, sb);
                sb.append(ch); // 공백은 그대로 출력
            } else { // 문자가 나온 경우 스택에 담음
                stack.push(ch);
            }
        }

        // 남은 단어 출력
        printStack(stack, sb);

        System.out.println(sb.toString());
    }

    // 스택에 담긴 단어를 역순으로 StringBuilder에 추가하여 출력
    private static void printStack(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}