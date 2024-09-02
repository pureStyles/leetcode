package Tree;

import java.util.HashMap;

public class Solution_0902 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return _buildTree(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode _buildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        int root = postorder[postorder_right];
        int inorder_root_index = map.get(root);
        // root节点左侧的都是左子树
        int len_left_subTree = inorder_root_index - inorder_left;

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = _buildTree(inorder, postorder, inorder_left, inorder_root_index - 1, postorder_left, postorder_left + len_left_subTree - 1);
        rootNode.right = _buildTree(inorder, postorder, inorder_root_index + 1, inorder_right, postorder_left + len_left_subTree, postorder_right - 1);
        return rootNode;
    }
}
