package leetcode.easy;

import com.sun.source.tree.Tree;

/**
 * 2331. Evaluate Boolean Binary Tree
 */
public class EvaluateBooleanBinaryTree {
    public static boolean evaluateTree(TreeNode root) {
        return recur(root);
    }
    private static boolean recur(TreeNode root) {
        if(root.val == 2){
            return recur(root.left) | recur(root.right);
        } else if(root.val == 3){
            return recur(root.left) & recur(root.right);
        } else if(root.val == 0){
            return false;
        } else {
            return true;
        }
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
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode zero = new TreeNode(0);

        two.left = one;
        two.right = three;
        three.left = zero;
        three.right = new TreeNode(1);
        System.out.println(evaluateTree(two));
    }
}
