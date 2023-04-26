package leetcode.easy.solution;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArraytoBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    private static TreeNode helper(int[] num, int s, int e) {
        if(s > e){
            return null;
        }
        int half = (s + e)/2;
        TreeNode treeNode = new TreeNode(num[half]);
        treeNode.left = helper(num,s,half-1);
        treeNode.right = helper(num,half+1,e);
        return treeNode;
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

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
