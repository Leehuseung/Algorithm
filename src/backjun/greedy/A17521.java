package backjun.greedy;

import java.util.Scanner;
/*

적고 - 크고 - 적고

크고 - 적고 - 크고

이렇게 분리했기 떄문에, 동일 - 동일 - 동일 - 크다

같은케이스에서 대처가 불가능했음..

기준일 다음날이 오르는경우 무조건 산다면, 특정값에서 처음 오르는 시점 캐치 가능
기준일 다음날이 내리는경우 무조건 산다면, 특정값에서 처음 떨어지는 시점 캐치 가능

 */
public class A17521 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long W = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long coin = 0;
        for (int i = 0; i < arr.length-1; i++) {
            //다음날 오르면 산다.
            if(arr[i] < arr[i+1]){
                coin += W / arr[i];
                W = W % arr[i];
            //다음날 떨어지면 판다.
            }else if(arr[i] > arr[i+1]){
                W += coin * arr[i];
                coin = 0;
            }
        }
        W = W + coin * arr[n-1];
        System.out.println(W);
    }
}


