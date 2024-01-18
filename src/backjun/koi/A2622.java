package backjun.koi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2622 {
	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int K = Integer.parseInt(bf.readLine());
			
			int result = 0;
			for(int i = 1; i < K; i++) {
				for(int j = i; j < K; j++) {
					int t = K - (i + j);
					if(j > t) {
						break;
					}
					if(t  < i + j) {
						result++;
						System.out.println(i+""+j+""+t);
					}
				}
			}

			bw.write(String.valueOf(result));
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
