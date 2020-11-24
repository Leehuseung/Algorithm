package backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C15552 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(bf.readLine());
		
		int a,b;
		for(int i = 0; i < T ; i++) {
			a = Integer.parseInt(bf.readLine());
			b = Integer.parseInt(bf.readLine());
			System.out.println(a+b);
		}
		bw.flush();
		bw.close();
		
	}
}
