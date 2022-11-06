package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        recur(root,list);
        return list;
    }

    public static void recur(TreeNode tree, List<Integer> list){
        if(tree == null) return;
        recur(tree.left,list);
        recur(tree.right,list);
        list.add(tree.val);
    }

    public static class TreeNode {
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
