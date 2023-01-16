package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 */
public class NaryTreePreorderTraversal {
    public static List<Integer> preorder(NaryTreePostorderTraversal.Node root) {
        List<Integer> list = new ArrayList<>();
        recur(root,list);
        return list;
    }

    private static void recur(NaryTreePostorderTraversal.Node root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        List<NaryTreePostorderTraversal.Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            NaryTreePostorderTraversal.Node node = children.get(i);
            recur(node,list);
        }
    }

    static class Node {
        public int val;
        public List<NaryTreePostorderTraversal.Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<NaryTreePostorderTraversal.Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
