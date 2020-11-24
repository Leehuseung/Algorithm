package backjun;

import java.util.Scanner;

public class A10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,T;
		T = sc.nextInt();
		
		for(int i = 0; i < T ; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a+b);
		}
	}
}
