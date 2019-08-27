package backjun.array;

import java.util.Scanner;

public class A1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		double[] arr = new double[length];
		int maxIndex = 0;
		double avg = 0;
		
		for(int i=0; i<length ; i++) {
			arr[i] = sc.nextInt();
		}
		double max=arr[0];
		
		for(int i=0; i<length ; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		for(int i=0; i<length ; i++) {
			arr[i] = (arr[i]/max)*100;
			avg += arr[i];
		}
		System.out.printf("%.3f",(avg+max)/length);
		
	}
}
