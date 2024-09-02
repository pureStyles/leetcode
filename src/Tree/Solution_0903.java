package Tree;

public class Solution_0903 {
    public int sumNumbers(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int temp = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return DFS(root.left, temp) + DFS(root.right, temp);
    }
}
