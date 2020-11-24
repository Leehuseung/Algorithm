package backjun.etc;

import java.util.Scanner;

public class A2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		String c = b.toString();
		for(int i = c.length()-1; i >= 0 ; i--) {
			System.out.println(a*Integer.parseInt(c.charAt(i)+""));
		}
		System.out.println(a*b);
	}
}
