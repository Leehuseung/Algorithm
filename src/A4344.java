import java.util.Scanner;

public class A4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] score = new int[1000];
		for(int i = 0; i < num ; i ++) {
			int num2 = sc.nextInt();
			int total = 0;
			double avg = 0;
			double count = 0;
			for(int k = 0; k < num2 ; k++) {
				score[k] = sc.nextInt();
				total += score[k];
				if(k == (num2-1)) {
					avg = total / num2;
				}
//				System.out.println("평균:"+avg);
			}
			for(int j = 0; j < num2 ; j++) {
//				System.out.println("score["+j+"]는 : "+score[j]+"avg는 : "+avg);
				if(score[j] > avg) {
					count ++;
				}
				if(j == (num2-1)) {
//					System.out.println("최종 count :"+count + "");
					double result = (count/num2)*100;
					result = Math.round(result*1000)/1000.0;
					System.out.printf("%.3f%%\n",result);
//					System.out.printf("%.3f",(Math.round(count/num)*1000/1000.0)+"%");
				}
			}
		}
	}
}
