package backjun.function;

import java.util.Scanner;

public class A15596 {
	long sum(int[] a) {
        long ans = 0;
        for(int i = 0; i < a.length; i++) {
        	ans += a[i];
        }
        return ans;
    }
}
