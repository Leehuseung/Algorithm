package backjun.etc;

import java.util.Scanner;

public class A11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,T;
		T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			a = sc.nextInt();
			b= sc.nextInt();
			System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,a+b);
		}
	}
}
