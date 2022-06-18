package leetcode.easy;
/**
 * LeetCode Easy 2236. Root Equals Sum of Children
 */
public class RootEqualSumOfChildren {

    public static boolean checkTree(TreeNode root) {

        if((root.left.val + root.right.val) == root.val){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {


    }


    class TreeNode {
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
}
