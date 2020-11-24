package backjun.koi2020_2.ele;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A20186 {
	public static void main(String[] args) {
		
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			StringTokenizer st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] resultArr = new int[K];
			
			HashSet aa = new HashSet();
			
			//뽑는 수만큼 돌자
			for(int i = K-1; i >= 0; i--){
				int max = 0;
				int maxIndex = -1;
				for(int j = 0; j < a.length; j++) {
					if(a[j] > max) {
						if(!aa.contains(j)) {
							max = a[j];
							maxIndex = j;
						}
					}
				}
				aa.add(maxIndex);
				resultArr[i] = max;
			};
			
			int result = 0;
			for(int i = 0 ; i < resultArr.length; i++) {
				result += resultArr[i];
			}
			
			int minus = 0;
			for(int i = K-1; i >0; i--) {
				minus += i;
			}

			bw.write(String.valueOf(result-minus));
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}