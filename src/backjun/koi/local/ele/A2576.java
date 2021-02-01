package backjun.koi.local.ele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class A2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] % 2) == 1){
                list.add(arr[i]);
                sum += arr[i];
            }
        }

        Collections.sort(list);

        if(list.size() == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
}
