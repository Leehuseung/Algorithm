package backjun.array;

import java.util.Scanner;

public class A10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		
		for(int i=0; i<length ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max=arr[0];
		int min=arr[0];
		
		for(int i=0; i<length ; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println(min + " "+ max);
	}
}
