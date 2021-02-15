package backjun.koi.local.ele;

import java.util.*;

public class A2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int returnNum = 0;

		int num = Integer.parseInt(sc.nextLine());

		int forNum = Integer.parseInt(sc.nextLine());

		ArrayList<Integer>[] arr = new ArrayList[num+1];
		Boolean[] boolArr = new Boolean[num+1];

		for (int i = 0; i < arr.length; i++) {
			arr[i]=new ArrayList<Integer>();
			boolArr[i] = false;
		}

		for(int i = 0; i < forNum; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}

		dfs(1,arr,boolArr);

		for(boolean bool : boolArr){
			if(bool == true){
				returnNum++;
			}
		}
		System.out.println(returnNum-1);
	}

	private static void dfs(int i, ArrayList<Integer>[] arr, Boolean[] bool) {
		bool[i] = true;
		for(int num : arr[i]){
			if(bool[num] == false){
				dfs(num,arr,bool);
			}
		}
	}
}
