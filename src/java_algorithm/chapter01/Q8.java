package java_algorithm.chapter01;

import java.util.Scanner;
//가우스의 덧셈
public class Q8 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		
		int sum = (1+num)*num/2;
		
		System.out.println(sum);
	}
}
