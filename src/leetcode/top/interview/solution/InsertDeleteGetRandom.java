package leetcode.top.interview.solution;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class InsertDeleteGetRandom {

    static class RandomizedSet {

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return true;
        }

        public boolean remove(int val) {
            return false;
        }

        public int getRandom() {
            return 0;
        }
    }


    static class BestRandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        java.util.Random rand = new java.util.Random();
        /** Initialize your data structure here. */
        public BestRandomizedSet() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if ( contain ) return false;
            locs.put( val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if ( ! contain ) return false;
            int loc = locs.get(val);
            if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1 );
                nums.set( loc , lastone );
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get( rand.nextInt(nums.size()) );
        }
    }

    static class myRandomizedSet {
        int number = 0;
        Set<Integer> set;
        List<Integer> list;
        java.util.Random rand = new java.util.Random();

        public myRandomizedSet() {
            set = new HashSet<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(set.contains(val)) return false;
            list.add(val);
            return set.add(val);
        }

        public boolean remove(int val) {
            if(!set.contains(val)) return false;
            int k = 0;
            //개선여지가 있음. O(n)
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == val){
                    k = i;
                    break;
                }
            }
            list.remove(k);
            return set.remove(val);
        }

        public int getRandom() {
            if(number >= list.size()) {
                number = 0;
            }
            return list.get(rand.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}
