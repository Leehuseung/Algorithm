package backjun.implement;

import java.util.Scanner;

/**
 * 0 만들기
 */
public class A7490_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            dfs(0,1, 1,"1",k, 1);
            System.out.println();
        }
    }

    private static void dfs(int total, int num, int t,String s, int depth, int op) {
        if(t == depth){
            total += (num * op);
            if(total == 0) {
                System.out.println(s);
            }
            return;
        }

        int next = t+1;

        dfs(total,                num*10+(t+1),t+1 ,s + " " + next, depth, op);
        dfs(total+(num*op),t+1, t+1, s + "+" + next, depth, 1);
        dfs(total+(num*op),t+1,t+1,s + "-" + next, depth, -1);
    }
}
