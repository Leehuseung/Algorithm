package backjun.array;

import java.util.Scanner;

public class A2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String result = a*b*c+"";
		
		String[] arr = result.split("");

		int[] resultArr = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i<arr.length ; i++) {
			int index = Integer.parseInt(arr[i]);
			resultArr[index] += 1;
		}
		
		for(int i = 0; i<10 ; i++) {
			System.out.println(resultArr[i]);
		}
		
	}
}
