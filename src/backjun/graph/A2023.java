package backjun.graph;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 신기한 소수
 */
public class A2023 {
    static int[] primes = new int[]{0,1,2,3,4,5,6,7,8,9};
    static PriorityQueue<Integer> pq;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            backTracking(primes[i], primes[i], 1);
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static void backTracking(int now, int sum, int cnt) {
        if(!isPrime(sum)) {
            return;
        }
        if(cnt == N) {
            if(isPrime(sum)) {
                pq.add(sum);
            }
            return;
        }

        for (int i = 0; i < primes.length; i++) {
            int newSum = 0;
            int copySum = sum;
            int c = 0;
            while(copySum != 0) {
                int mok = (int) (copySum / Math.pow(10, c+1));
                int na = (int) (copySum % Math.pow(10, c+1));

                copySum -= (int) (mok * Math.pow(10, c+1));
                copySum -= (int) (na * Math.pow(10, c));

                newSum += (int) (mok * Math.pow(10, c+2));
                newSum += (int) (na * Math.pow(10, c+1));
                c++;
            }

            backTracking(primes[i], newSum + primes[i], cnt+1);
        }
    }

    static boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


//        int a = 23;
//        int k = 0;
//        int aim = 2;
//        int newSum = 0;
//        while(k != aim) {
//            int mok = (int) (a / (Math.pow(10, k+1)));
//            int na =  (int) (a % (Math.pow(10, k+1)));
//            newSum += (int) (mok * (Math.pow(10, k+2)));
//            newSum += (int) (na * (Math.pow(10, k+1)));
//            k++;
//        }