package backjun.etc;

import java.util.Scanner;

/*

바로 "45분 일찍 알람 맞추기"이다.
이 방법은 단순하다. 원래 맞춰져있는 알람을 45분 앞서는 시간으로 바꾸는 것이다. 어차피 알람 소리를 들으면, 알람을 끄고 조금 더 잘 것이기 때문이다. 이 방법을 사용하면, 
매일 아침 더 잤다는 기분을 느낄 수 있고, 학교도 지각하지 않게 된다.
현재 상근이가 맞춰논 알람 시각이 주어졌을 때, 창영이의 방법을 사용한다면, 이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.
 */
public class A2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//두정수 H,M
		int H;
		int M;
		H = sc.nextInt();
		M = sc.nextInt();
		
		if(M >=45) {
			M = M - 45;
		}else{
			M = 15+M;
			if(H == 0) {
				H += 23;
			}	else {
				H --;
			}
		}
		System.out.println(H);
		System.out.println(M);
	}
}
