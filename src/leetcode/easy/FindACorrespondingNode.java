package leetcode.easy;

/**
 *  1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindACorrespondingNode {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return searchNode(cloned, target.val);
    }

    private TreeNode searchNode(TreeNode cloned, int val) {
        if(cloned.val == val){
            return cloned;
        }

        if(cloned.left != null){
            TreeNode left = searchNode(cloned.left, val);
            if(left != null) return left;
        }

        if(cloned.right != null){
            TreeNode right = searchNode(cloned.right, val);
            if(right != null) return right;
        }

        return null;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
