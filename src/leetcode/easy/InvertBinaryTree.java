package leetcode.easy;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    private void recursive(TreeNode root) {
        if(root == null) return;
        recursive(root.left);
        recursive(root.right);
        TreeNode box = root.left;
        root.left = root.right;
        root.right = box;
    }

    class TreeNode {
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
}
