package backjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * AC
 */
public class A5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] command = s.toCharArray();
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            String arr = br.readLine();
            arr = arr.substring(1, arr.length() - 1);; // 대괄호 제거
            String[] nums = arr.split(","); // 쉼표를 기준으로 문자열 분리
            Deque<String> deque = new LinkedList<>(Arrays.asList(nums));


            run(command, deque);
        }
    }

    private static void run(char[] command, Deque<String> nums) {
        StringBuilder sb = new StringBuilder();
        boolean reverse = false;
        for (char c : command) {
            if (c == 'R') {
                reverse = !reverse;
            } else {
                if(nums.isEmpty()){
                    sb.append("error");
                    System.out.println(sb);
                    return;
                } else {
                    if(reverse){
                        String k = nums.pollLast();
                        if(k.isEmpty()) {
                            sb.append("error");
                            System.out.println(sb);
                            return;
                        }
                    } else {
                        String k = nums.pollFirst();
                        if(k.isEmpty()) {
                            sb.append("error");
                            System.out.println(sb);
                            return;
                        }
                    }
                }
            }
        }
        sb.append("[");
        while(!nums.isEmpty()) {
            if(reverse){
                sb.append(nums.pollLast());
            } else {
                sb.append(nums.pollFirst());
            }
            if(!nums.isEmpty()) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
