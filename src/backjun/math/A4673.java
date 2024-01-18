package backjun.math;

import java.util.Arrays;

public class A4673 {
	public static int self(int a) {
		String b = a + "";
		int sum = 0;
		for(int i = 0 ; i < b.length() ; i++) {
			int c = 0 ;
			c = Integer.parseInt(b.charAt(i)+"");
			sum += c;
		}
		return a+sum;
	}
	
	public static void main(String[] args) {
		int[] result = new int[10000];
		for(int i = 0 ; i < 10000 ; i++) {
			result[i] = self(i);
		}
		Arrays.sort(result);
		for(int i = 0; i < 10000; i++) {
			boolean aaa = false;
			for(int k = 0 ; k < 10000; k++) {
				if( i == result[k]) {
					aaa = true;
				}
			}
			if(aaa == false) {
				System.out.println(i);
			}
		}
	}
}
