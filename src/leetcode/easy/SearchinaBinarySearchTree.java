package leetcode.easy;

/**
 * LeetCode 700. Search in a Binary Search Tree
 */
public class SearchinaBinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        root = search(root, val);
        return root;
    }

    //best solution
    public static TreeNode search(TreeNode root, int val){
        if(root == null || root.val == val)
            return root;
        else if(root.val>val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
    }
//
//    public static TreeNode searchBST(TreeNode root, int val) {
//        return recur(root,val);
//    }
//
//    public static TreeNode recur(TreeNode root, int val) {
//        if(root == null){
//            return null;
//        }
//        if(root.val == val){
//            return root;
//        }
//        TreeNode left = recur(root.left,val);
//        if(left != null){
//            return left;
//        };
//        TreeNode right = recur(root.right,val);
//        if(right != null){
//            return right;
//        }
//        return null;
//    }

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
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        four.left = two;
        four.right = seven;
        four.left.left = one;
        four.left.right = three;

        searchBST(four,2);
    }
}
