package Tree;

import com.sun.source.tree.Tree;

public class Solution_0828 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean leftIsSame = isSameTree(p.left, q.left);
        boolean rightIsSame = isSameTree(p.right, q.right);
        return p.val == q.val && leftIsSame && rightIsSame;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
}
