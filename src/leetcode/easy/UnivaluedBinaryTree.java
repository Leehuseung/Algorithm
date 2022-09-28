package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 965. Univalued Binary Tree
 */
public class UnivaluedBinaryTree {
    static Set<Integer> set;
    public static boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        set = new HashSet<>();
        return recur(root);
    }

    public static boolean recur(TreeNode treenode) {
        if(treenode == null){
            return true;
        }
        set.add(treenode.val);
        if(set.size() == 2){
            return false;
        }
        if(!recur(treenode.left)){
            return false;
        };
        if(!recur(treenode.right)){
            return false;
        };
        return true;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;

        System.out.println(isUnivalTree(one));
    }
}
