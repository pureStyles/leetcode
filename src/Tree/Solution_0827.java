package Tree;

public class Solution_0827 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }
        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }
}
