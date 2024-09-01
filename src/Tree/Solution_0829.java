package Tree;

import java.util.HashMap;

public class Solution_0829 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return _buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode _buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root_index = preorder_left;
        int inorder_root_index = map.get(preorder[preorder_root_index]);

        int len_left_subTree = inorder_root_index - inorder_left;

        TreeNode root = new TreeNode(preorder[preorder_root_index]);

        root.left = _buildTree(preorder, inorder, preorder_left + 1, preorder_left + len_left_subTree, inorder_left, inorder_root_index - 1);
        root.right = _buildTree(preorder, inorder, preorder_left + len_left_subTree + 1, preorder_right, inorder_root_index + 1, inorder_right);
        return root;
    }
}
