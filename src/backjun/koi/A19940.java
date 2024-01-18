/*0 0 0 1 0
0 0 0 2 0
0 0 0 3 0
0 0 0 4 0
0 0 0 5 0
0 1 0 0 4
0 1 0 0 3
0 1 0 0 2
0 1 0 0 1
0 1 0 0 0
0 1 0 1 0
0 1 0 2 0
0 1 0 3 0
0 1 0 4 0
0 1 0 5 0
0 2 0 0 4
0 2 0 0 3
0 2 0 0 2
0 2 0 0 1
0 2 0 0 0
0 2 0 1 0
0 2 0 2 0
0 2 0 3 0
0 2 0 4 0
0 2 0 5 0
0 3 0 0 4
0 3 0 0 3
0 3 0 0 2
0 3 0 0 1
0 3 0 0 0
0 3 0 1 0
0 3 0 2 0
0 3 0 3 0
0 3 0 4 0
0 3 0 5 0
1 0 2 0 4
1 0 2 0 3
1 0 2 0 2
1 0 2 0 1
1 0 2 0 0
1 0 2 1 0
1 0 2 2 0
1 0 2 3 0
1 0 2 4 0
1 0 1 0 5
1 0 1 0 4
1 0 1 0 3
1 0 1 0 2
1 0 1 0 1
1 0 1 0 0
1 0 1 1 0
1 0 1 2 0
1 0 1 3 0
1 0 1 4 0
1 0 0 0 5
1 0 0 0 4
1 0 0 0 3
1 0 0 0 2
1 0 0 0 1
1 0 0 0 0
 */
package backjun.koi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class A19940 {
	public static void main(String[] args)  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int T = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i < T; i++) {
				
				int n = Integer.parseInt(br.readLine());
				int a,b,c,d,e;
				a=b=c=d=e=0;
				
				//60보다 크면 60보다 작게만들어준다.
				if(n >= 60) {
					a = n/60;
					n = n - (a * 60);
				}
				
				//60보다 작게만든수가 35보다 크면 60을 더해서 내려온다
				if(n > 35) {
					a++;
					int mm = n%10;
					//나머지가  5보다작으면
					if( mm < 5) {
						//1을 더해서 접근
						c = 6 - (n/10);
					    d = mm;
					} else {
						//1을 빼서 접근
						c = (60 - n)/10;
						e = 10 - mm;
					}
				//36보다 작을때
				} else {
					//나머지
					int mm = n%10;
					//10의자리
					b = n/10; 
					//나머지가  6보다작으면
					if( mm < 6) {
						d = mm;
					} else {
						//10을더한뒤 --
						b++;
						e = 10 - mm;
					}
				}
				bw.write(a+" "+b+" "+c+" "+d+" "+e+"\n");
			}
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
