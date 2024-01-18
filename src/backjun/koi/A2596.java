package backjun.koi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2596 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int[][] arr = {
						   {0,0,0,0,0,0},
						   {0,0,1,1,1,1},
						   {0,1,0,0,1,1},
						   {0,1,1,1,0,0},
						   {1,0,0,1,1,0},
						   {1,0,1,0,0,1},
						   {1,1,0,1,0,1},
						   {1,1,1,0,1,0}
					  	  };
			
			char[] answerArr = {'A','B','C','D','E','F','G','H'};
			
			//틀린거
			int loop = Integer.parseInt(bf.readLine());
			String findChar = bf.readLine();
			
			
			String[] charArr = findChar.split("");
			
			String resultChar = "";
			loop1 :
			for(int k = 0; k < loop ;k++) {
				for(int t = 0; t < 8; t++) {
					int cnt = 0;
					for(int j = 0; j < 6; j++) {
						int encodeNum = Integer.parseInt(charArr[j+(6*k)]);
						if(!(encodeNum == arr[t][j])) {
							cnt++;
						}
					}
					if (2 > cnt ) {
						resultChar += answerArr[t];
						continue loop1;
					//마지막문자까지 검사(H)해서 1개이상 틀렸을경우 번호를 반환함 
					}else if(t == 7 && cnt > 1) {
						resultChar = (k+1)+"";
						break loop1;
					}
				}
			}
			bw.write(resultChar);
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
			
