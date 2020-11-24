package backjun.koi2020_2.ele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A20187 {
	public static void main(String[] args) {
		
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int K = Integer.parseInt(bf.readLine());
			
			String how = bf.readLine();
			
			String[] howArr = how.split(" ");
			
			int H = Integer.parseInt(bf.readLine());
			
			String result = "";
			
			String backWord = howArr[howArr.length-1] + "" + howArr[howArr.length-2];
			String highLine = "";
			String lowLine = "";
			
			switch(backWord) {
			case "DR" :
				switch(H) {
				case 0 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 1 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 2 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 3 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				}
				break;
			case "RD" :
				switch(H) {
				case 0 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 1 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 2 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 3 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				}
				break;
			case "DL" : 
				switch(H) {
				case 0 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 1 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 2 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 3 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				}
				break;
			case "LD" : 
				switch(H) {
				case 0 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 1 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 2 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 3 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				}
				break;
			case "UR" : 
				switch(H) {
				case 0 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 1 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 2 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 3 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				}
				break;
			case "RU" : 
				switch(H) {
				case 0 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 1 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 2 :
					highLine = "3 2";
					lowLine  = "1 0";
					break;
				case 3 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				}
				break;
			case "UL" : 
				switch(H) {
				case 0 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 1 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 2 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 3 :
					highLine = "3 2";
					lowLine  = "1 0 ";
					break;
				}
				break;
			case "LU" : 
				switch(H) {
				case 0 :
					highLine = "0 1";
					lowLine  = "2 3";
					break;
				case 1 :
					highLine = "1 0";
					lowLine  = "3 2";
					break;
				case 2 :
					highLine = "2 3";
					lowLine  = "0 1";
					break;
				case 3 :
					highLine = "3 2";
					lowLine  = "1 0 ";
					break;
				}
				break;
			}
			
			
			
			int lineFor = 1;
			
			for(int i = K; i > 0; i--) {
				lineFor = 2 * lineFor;
			}
			
			for(int i = 0 ; i < lineFor/2; i++) {
				for(int j = 0; j < lineFor/2; j++) {
					if(j == lineFor/2-1) {
						result += highLine;
					} else {
						result += highLine+" ";
					}
				}
				result += "\n";
				for(int j = 0; j < lineFor/2; j++) {
					if(j == lineFor/2-1) {
						result += lowLine;
					} else {
						result += lowLine+" ";
					}
				}
				if(i == lineFor/2-1) {
					result += "";
				} else {
					result += "\n";
				}
			}
			


			bw.write(result);
			bw.flush();
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
