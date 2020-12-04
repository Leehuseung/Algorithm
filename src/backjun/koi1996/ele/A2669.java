package backjun.koi1996.ele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2669 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			boolean[][] resultBool = new boolean[101][101];
			String[] arrXY = new String[4];
			int sum = 0;
			
			for(int i = 0 ; i < 4; i++) {
				String arr = bf.readLine();
				arrXY = arr.split(" ");
				
				int x1 = Integer.parseInt(arrXY[0]);
				int y1 = Integer.parseInt(arrXY[1]);
				int x2 = Integer.parseInt(arrXY[2]);
				int y2 = Integer.parseInt(arrXY[3]);
				
				for(int k = x1; k < x2; k++) {
					for(int t = y1; t < y2; t++) {
						if(!resultBool[k][t]) {
							resultBool[k][t] = true;
							sum++;
						}
					}
				}
			}
		
			bw.write(String.valueOf(sum));
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
