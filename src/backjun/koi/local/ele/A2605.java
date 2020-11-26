package backjun.koi.local.ele;

import java.util.Scanner;

public class A2605 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int len = Integer.parseInt(sc.nextLine());
		
		int arr[] = new int[len];
		
		int[] pickArr = new int[len];
		
		for(int i = 0; i < len; i++) {
			pickArr[i] = sc.nextInt();
			arr[i] = i+1;
		}
		
		
		int tempIndex = 0;
		int temp = 0;
		
		for(int i = 0 ; i < pickArr.length; i++) {
			int pickNum = pickArr[i];
			
			tempIndex = i - pickNum;
			
			temp = arr[i];
			
			for(int  k=i; k >tempIndex; k--) {
				arr[k] = arr[k-1];
			}
			
			arr[tempIndex] = temp;
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
