package leetcode.easy;

/**
 * Increasing Order Search Tree
 */
public class IncreasingOrderSearchTree {

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = new TreeNode(-1);
        recur(root,newTree);
        return newTree;
    }

    public static void recur(TreeNode node,TreeNode newTree) {
        if(node == null){
            return;
        }
        recur(node.left,newTree);
        makeNewTree(newTree, node.val);
        recur(node.right,newTree);
    }

    private static void makeNewTree(TreeNode newTree, int val) {
        if(newTree.val == -1){
            newTree.val = val;
        } else {
            if(newTree.right == null){
                newTree.right = new TreeNode(val);
            } else {
                TreeNode right = newTree.right;
                while(right.right != null) {
                    right = right.right;
                }
                right.right = new TreeNode(val);
            }
        }
    }

    static class TreeNode {
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
        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode s = new TreeNode(6);
        TreeNode e = new TreeNode(8);
        TreeNode n = new TreeNode(9);
        TreeNode seven = new TreeNode(7);

        root.left = three;
        root.right = s;
        root.left.left = two;
        root.left.right = f;
        root.left.left.left = one;
        root.right.right = e;
        root.right.right.left= seven;
        root.right.right.right= n;

        increasingBST(root);

        System.out.println(root);
    }
}

