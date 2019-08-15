package backjun;

import java.util.Scanner;

public class A11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,T;
		T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			a = sc.nextInt();
			b= sc.nextInt();
			System.out.println("Case #"+i+": "+(a+b));
		}
	}
}
