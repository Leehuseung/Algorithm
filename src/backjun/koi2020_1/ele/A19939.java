package backjun.koi2020_1.ele;

import java.util.Scanner;

public class A19939 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//공의갯수
		int N = sc.nextInt();
		//팀의수
		int K = sc.nextInt();
		
		int[] arr = new int[K];
		
		int ballCnt = 0;
		
		for(int i = 0; i < K; i++) {
			arr[i] = i+1;
			ballCnt += i+1;
		}
		
		//최소로주고 남은 공의 수
		int addBall = N-ballCnt;
		
		if(N < ballCnt) {
			System.out.println(-1);
			return;
		} else if(addBall == 0) {
			System.out.println(K-1);
			return;
		}
		
		int J = K-1;
		
		for(int i = addBall; i > 0; i--) {
			arr[J] = arr[J]+1;
			J--;
			if(J == -1) {
				J = K-1;
			}
		}
		
		System.out.println(arr[K-1]-arr[0]);
	}
}
