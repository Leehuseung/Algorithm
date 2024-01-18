package backjun.koi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A2309 {
	public static void main(String[] args) {
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int[] arr = new int[9];
			
			for(int i = 0; i <9; i++) {
			    arr[i] = Integer.parseInt(bf.readLine());
			}
			
			int sum = 0;
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			for(int i = 0 ; i < arr.length; i++) {
				sum += arr[i];
			}
			
			a = sum;
			
			
			loop :
			for(int i = 0; i < arr.length-1; i++) {
				for(int j = i+1; j < arr.length; j++){
					a = sum - arr[i] - arr[j];
					if(a == 100) {
						b = i;
						c = j;
						break loop;
					}
					a = sum;
				}
			}
			
			int[] resultArr = new int[7];
			
			for(int i = 0 ; i < arr.length; i++) {
				if(i == b || i == c) {
					continue;
				}
				resultArr[d] = arr[i];
				d++;
			}
			
			Arrays.sort(resultArr);
			
			for(int i = 0 ; i < resultArr.length; i++) {
				System.out.println(resultArr[i]);
			}
			
		}catch(Exception e) {
			
		}
	}
}
