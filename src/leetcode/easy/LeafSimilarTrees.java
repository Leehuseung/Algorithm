package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 */
public class LeafSimilarTrees {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        recursive(root1,list1);
        recursive(root2,list2);

        if(list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void recursive(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            list.add(root.val);
        }

        if(root.left != null) recursive(root.left,list);
        if(root.right != null) recursive(root.right,list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
}
