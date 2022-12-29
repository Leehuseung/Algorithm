package leetcode.easy;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */
public class SumofRootToLeafBinaryNumbers {
    static int sum = 0;
    public static int sumRootToLeaf(TreeNode root) {
        sum = 0;
        recursive(root, root.val+"");
        return sum;
    }

    private static void recursive(TreeNode root, String s) {
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s,2);
            return;
        }
        if(root.left != null){
            recursive(root.left, s + root.left.val);
        }
        if(root.right != null) {
            recursive(root.right, s + root.right.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }
    static class TreeNode {
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
