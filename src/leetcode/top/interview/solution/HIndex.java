package leetcode.top.interview.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 274. H-Index
 */
public class HIndex {
    public static int hIndex(int[] citations) {
        return 0;
    }
    public static int betsHIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
    public static int solHIndex(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        for (int i = 0; i < arr.length; i++) {
            if(i >= arr[i]) return i;
        }
        return citations.length;
    }

    public static void main(String[] args) {
        System.out.println(betsHIndex(new int[] {3, 0, 6, 1, 5}));
//        System.out.println(hIndex(new int[] {3, 0, 6, 1, 5}));
//        System.out.println(hIndex(new int[] {1, 3, 1}));
//        System.out.println(hIndex(new int[] {100}));
    }
}
