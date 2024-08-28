package Tree;

public class Solution_0827 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }
}
