package java_algorithm.chapter01;

import java.util.Scanner;

public class Q11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("자리수는  "+whatFigure(num)+"입니다.");
		
	}
	public static int whatFigure(int num) {
		String figure = ""+num;
		return figure.length();
	}
}
