package codding_studio.level1;

import java.util.ArrayList;
import java.util.Collections;

public class SinapSoft {
	public static void main(String[] args) {
		String arr = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
		
		String[] arr2  = arr.split(",");
		
		ArrayList<String> arrDelete = new ArrayList<>();
		
		int kimCount = 0;
		int leeCount = 0;
		
		for(int i = 0 ; i < arr2.length ; i++) {
			if((arr2[i].charAt(0)+"").equals("김")) {
				kimCount++;
			}else if((arr2[i].charAt(0)+"").equals("이")) {
				leeCount++;
			}
		}
		for(int i = 0 ; i < arr2.length ; i++) {
			if(!arrDelete.contains(arr2[i])) {
				arrDelete.add(arr2[i]);
			};
		}
		
		System.out.println("김씨는"+kimCount+"명입니다.");
		System.out.println("이씨는"+leeCount+"명입니다.");
		
		//중복 이름 제거
		System.out.println(arrDelete);
		//오름차순
		Collections.sort(arrDelete);
		System.out.println(arrDelete);
	}
}
