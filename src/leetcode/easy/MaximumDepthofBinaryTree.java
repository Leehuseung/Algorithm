package leetcode.easy;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        return recursive(root,0);
    }

    private int recursive(TreeNode root,int depth) {
        if(root == null){
            return depth;
        }
        ++depth;

        int left = recursive(root.left,depth);
        int right = recursive(root.right,depth);
        return Math.max(left,right);
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
}
