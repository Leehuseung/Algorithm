package leetcode.easy;

public class RangeSumOfBST {
    static int answer = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        answer = 0;
        recursive(root,low,high);
        return answer;
    }

    private static void recursive(TreeNode root, int low, int high) {
        if(root == null){
            return;
        }
        recursive(root.left,low,high);
        recursive(root.right,low,high);
        if(root.val >= low && root.val <= high){
            answer += root.val;
        }
    }

    public class TreeNode {
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
