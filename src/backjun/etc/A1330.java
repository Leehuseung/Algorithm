package backjun.etc;

import java.util.Scanner;

public class A1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a, b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a>b) {
			System.out.println(">");
		}else if(a<b) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
		
	}
}
