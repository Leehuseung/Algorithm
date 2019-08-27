package backjun.array;

import java.util.Scanner;

public class A2562 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		int index = 0;
		for(int i = 1; i <= 9; i++) {
			int num = scan.nextInt();
			if(num > max) {
				max = num;
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
