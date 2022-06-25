package leetcode.easy;
/**
 * 2194. Cells in a Range on an Excel Sheet
 */

import java.util.ArrayList;
import java.util.List;

public class CellsinaRangeonanExcelSheet {

    public static List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();

        String[] arr = s.split(":");
        String start = arr[0];
        String end = arr[1];

        char startChar = start.charAt(0);
        int startInt = Integer.parseInt(start.charAt(1) + "");

        char endChar = end.charAt(0);
        int endInt = Integer.parseInt(end.charAt(1) + "");

        for (char i = startChar; i <= endChar; i++) {
            for (int j = startInt; j <= endInt; j++) {
                list.add(i + "" +j);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(cellsInRange("K1:L2").toString()); //  ["K1","K2","L1","L2"]
        System.out.println(cellsInRange("A1:F1").toString()); //  ["A1","B1","C1","D1","E1","F1"]
    }
}
