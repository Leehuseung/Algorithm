package codding_studio.level1;

import java.util.Scanner;

public class BoardPaging {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("게시물의 총 개수를 입력하세요 :");
		double m = Integer.parseInt(sc.nextLine());
		System.out.println("한페이지에 보여줄 게시물 수를 입력하세요 : ");
		double n = Integer.parseInt(sc.nextLine());
		
		if(m == 0) {
			System.out.println(0);
		}else if(m/n <= 1) {
			System.out.println(1);
		}else if(m/n >1) {
			System.out.printf("%.0f",Math.ceil((m/n)));
		}
	}
}
