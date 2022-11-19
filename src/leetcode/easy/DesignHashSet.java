package leetcode.easy;

/**
 * 705. Design HashSet
 */
public class DesignHashSet {

    static class MyHashSet {
        boolean[] arr;
        public MyHashSet() {
            arr = new boolean[1000000];
        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        public boolean contains(int key) {
            return arr[key];
        }
    }

    public static void main(String[] args) {

    }
}