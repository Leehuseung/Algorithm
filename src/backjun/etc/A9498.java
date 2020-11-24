package backjun.etc;

import java.util.Scanner;
public class A9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
		
		if(a<101 && a>=90) {
			System.out.println("A");
		}else if(a>79) {
			System.out.println("B");
		}else if(a>69){
			System.out.println("C");
		}else if(a>59){
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
	}
}
