package leetcode.easy;

/**
 * LeetCode 617. Merge Two Binary Trees
 */
public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        recur(root1,root2);
        return root1;
    }

    private static void recur(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return;
        }
        root1.val = root1.val + root2.val;
        if(root1.left == null && root2.left != null){
            root1.left = new TreeNode(0);
        }
        recur(root1.left,root2.left);

        if(root1.right == null && root2.right != null){
            root1.right = new TreeNode(0);
        }
        recur(root1.right,root2.right);
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

    }
}
