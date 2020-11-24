package backjun.etc;

import java.util.Scanner;

public class A8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b = 0;
		a = sc.nextInt();
		
		for (int i = 1 ; i <= a ; i++) {
			b += i;
		}
		System.out.println(b);
		
	}
}
