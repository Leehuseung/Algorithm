package backjun;

import java.util.Scanner;

public class A2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			for(int k = 0 ; k <= i ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
