package backjun.math;

import java.util.Scanner;

public class A1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int numCopy = num;
		int plusNum;
		int newNum;
		int i = 0;

		if(num < 10) {
			//10보다 작으면 앞에 0을붙여 두자리 수를 만들고 
			num = Integer.parseInt("0"+num);
		}
		//num == 26
		
		while(true){
			plusNum = numCopy/10 + numCopy%10;		//8
			newNum = ((numCopy%10)*10) + plusNum%10;	//68
			numCopy = newNum;
			i++;
//			System.out.println(i+"번째계산============");
//			System.out.println(newNum);
			if(numCopy==num) {
				System.out.println(i);
				break;
			}
		}
	}
}
