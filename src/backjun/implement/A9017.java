package backjun.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 크로스 컨트리
 */
public class A9017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] cnt = new int[201]; // 1씩더함
            int[] five = new int[201]; // 1씩더함
            int[] total = new int[201];
            int N = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int t = sc.nextInt();
                list.add(t);
                cnt[t]++;
            }

            //6명이 안되면 제거해야한다.
            for (int j = 0; j < list.size();) {
                if(cnt[list.get(j)] < 6){
                    list.remove(j);
                    continue;
                }
                j++;
            }
            cnt = new int[201];

            for (int j = 0; j < list.size(); j++) {
                cnt[list.get(j)]++;
                //상위 4명의 total 을 계산해야 한다.
                if(cnt[list.get(j)] < 5){
                    total[list.get(j)] += j+1;
                }
                //5위는 별도로 기록해 놓는다.
                if(cnt[list.get(j)] == 5){
                    five[list.get(j)] = j+1;
                }
            }
            int result = 0;
            int MIN = Integer.MAX_VALUE;
            for (int j = 1; j < total.length; j++) {
                int to = total[j];
                if(to != 0 && MIN > to){
                    MIN = to;
                    result = j;
                //동일하면 5위가 작은사람으로.
                } else if (to != 0 && MIN == to) {
                    result = five[j] > five[result] ? result : j;
                }
            }
            System.out.println(result);
        }
    }
}
