package level2;

import java.util.TreeMap;

public class BinaryTree {
    TreeNode root;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            right = null;
            left = null;
        }
    }

    private TreeNode addNew(TreeNode curr, int val) {
        if (curr == null) {
            return new TreeNode(val);
        }
        if (curr.val > val) {
            curr.left = addNew(curr.left, val);
        } else if (curr.val < val) {
            curr.right = addNew(curr.right, val);
        }
        return curr;
    }

    public void addToTree(int val) {
        root = addNew(root, val);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int ld = depth(root.left);
            int rd = depth(root.right);
            return (Math.max(ld, rd) + 1);
        }
    }

    public int getDepth() {
        return depth(root);
    }

}
