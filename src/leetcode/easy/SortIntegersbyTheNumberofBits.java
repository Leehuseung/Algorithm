package leetcode.easy;


import java.util.Arrays;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 */
public class SortIntegersbyTheNumberofBits {

    public static int[] sortByBits(int[] arr) {
        Integer[] draft = new Integer[arr.length];
        boolean isAllBit = true;
        for (int i = 0; i < arr.length; i++) {
            draft[i] = arr[i];
            if(Integer.toBinaryString(arr[i]).replaceAll("0","").length() != 1){
                isAllBit = false;
            }
        }

        if(isAllBit){
            Arrays.sort(draft);
        } else {
            Arrays.sort(draft, (o1, o2) -> {
                int s1 = Integer.toBinaryString(o1).replaceAll("0","").length();
                int s2 = Integer.toBinaryString(o2).replaceAll("0","").length();
                if(s1 > s2){
                    return 1;
                } else if(s1 < s2){
                    return -1;
                } else {
                    if(o1 > o2){
                        return 1;
                    } else if(o1 < o2){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }

        int[] answer = new int[arr.length];
        for (int i = 0; i < draft.length; i++) {
            answer[i] = draft[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0,1,2,3,4,5,6,7,8}))); // [0,1,2,4,8,3,5,6,7]
        System.out.println(Arrays.toString(sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}))); // [1,2,4,8,16,32,64,128,256,512,1024]
        System.out.println(Arrays.toString(sortByBits(new int[]{1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631}))); // [1,624,1107,4401,8641,8742,377,1111,6978,3554,7694,9193,5311,6631,7403,7644]
    }

}
