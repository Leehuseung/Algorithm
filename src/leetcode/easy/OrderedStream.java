package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordere`d Stream
 */
public class OrderedStream {
    private String[] arr;

    private int ptr = 1;

    public OrderedStream(int n) {
        arr = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {

        arr[idKey] = value;

        List<String> list = new ArrayList<>();

        if(arr[ptr] == null){
            return list;
        } else {
            list.add(arr[ptr]);
            ptr++;
            while(ptr < arr.length && arr[ptr] != null){
                list.add(arr[ptr]);
                ptr++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc").toString()); // Inserts (3, "ccccc"), returns [].
        System.out.println(os.insert(1, "aaaaa").toString()); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        System.out.println(os.insert(2, "bbbbb").toString()); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        System.out.println(os.insert(5, "eeeee").toString()); // Inserts (5, "eeeee"), returns [].
        System.out.println(os.insert(4, "ddddd").toString()); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    }

}