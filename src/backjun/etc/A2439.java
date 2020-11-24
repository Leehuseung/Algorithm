package backjun.etc;

import java.util.Scanner;

public class A2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int i = T; i > 0 ; i--) {
			for(int k = i-1 ; k > 0 ; k--) {
				System.out.print(" ");
			}
			for(int j = i ; j <= T ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
