package leetcode.top.interview;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array (easy)
 */
public class MergeSortedArray {
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int lastindex = m+n-1;
        int index1 = m-1;
        int index2 = n-1;

        while(index2 >= 0) {
            if(index1 >=0 && arr1[index1] > arr2[index2]) {
                arr1[lastindex] = arr1[index1];
                index1--;
            }
            else {
                arr1[lastindex] = arr2[index2];
                index2--;
            }
            lastindex--;
        }
    }
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        for (int i = nums1.length-1; i >= 0 ; i--) {
            if(m-1 < 0){
                nums1[i] = nums2[n-1];
                n--;
                continue;
            } else if (n-1 < 0) {
                nums1[i] = nums1[m-1];
                m--;
                continue;
            }

            if(nums1[m-1] >= nums2[n-1]){
                nums1[i] = nums1[m-1];
                m--;
            } else {
                nums1[i] = nums2[n-1];
                n--;
            }
        }
    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = nums1.clone();
        int a = 0;
        int b = 0;
        if(n == 0) return;
        for (int i = 0; i < copy.length; i++) {
            if (a >= m) {
                nums1[i] = nums2[b];
                b++;
                continue;
            } else if (b >= n) {
                nums1[i] = copy[a];
                a++;
                continue;
            }
            if (copy[a] <= nums2[b]) {
                nums1[i] = copy[a];
                a++;
            } else {
                nums1[i] = nums2[b];
                b++;
            }
        }
    }


    /*
    Time complexity: O((m+n)log(m+n))
    space complexity: O(1)
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        merge(ints, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(ints));
//        merge(new int[]{1}, 1, new int[]{}, 0);
    }
}
