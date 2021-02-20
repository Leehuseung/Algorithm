package backjun.greedy;

import java.util.Scanner;

/*
단순히 최소값  Min으로 갱신하면서 풀었으면 될 문제임,,
 */

public class A13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] leng = new long[N-1];
        long[] prices = new long[N];

        boolean[] visit = new boolean[N-1];

        long price = 0;

        for (int i = 0; i < N-1; i++) {
            leng[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            if(visit[i] == false){
                long p = leng[i] * prices[i];
                price += p;
                visit[i] = true;
                for (int j = (i+1); j < N-1; j++) {
                    if(prices[j] <= prices[i]){
                        break;
                    }
                    if(prices[j] > prices[i] && visit[j] == false){
                        visit[j] = true;
                        price += leng[j] * prices[i];
                    }
                }
            }
        }
        System.out.println(price);
    }
}
