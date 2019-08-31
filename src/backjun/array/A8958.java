package backjun.array;

import java.util.Scanner;

public class A8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String OX;
		int num = sc.nextInt();
		int score = 0;
		for(int i = 0; i < num ; i ++) {
			OX = sc.next();
			int detailScore = 0;
			for(int k = 0; k < OX.length() ; k++) {
				if(OX.charAt(k) == 'O') {
					detailScore++;
				}else {
					detailScore = 0;
				}
				score += detailScore;
			}
			System.out.println(score);
			score = 0;
		}
	}
}
