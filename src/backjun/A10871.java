package backjun;

import java.util.Scanner;

public class A10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X;
		int K;
		X = sc.nextInt();
		K = sc.nextInt();
		int[] A = new int[X];
		
		for(int i = 0 ; i < X ; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < A.length ; i++) {
			if(A[i] < K) {
				System.out.print(A[i]+ " ");
			}
		}
	}
}
