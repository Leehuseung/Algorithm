package backjun.etc;

import java.util.Scanner;

public class A10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A,B,C = 0;
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		if(A >= B && A >= C && B >= C) {
			System.out.println(B);
			return;
		}
		if(A >= B && A >= C && C >= B) {
			System.out.println(C);
			return;
		}
		if(B >= A && B >= C && A >= C) {
			System.out.println(A);
			return;
		}
		if(B >= A && B >= C && C >= A) {
			System.out.println(C);
			return;
		}
		if(C >= A && C >= B && A >= B) {
			System.out.println(A);
			return;
		}
		if(C >= A && C >= B && B >= A) {
			System.out.println(B);
			return;
		}
	}
}
