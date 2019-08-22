package priv.algorithm.coding_interviews;

/**
 * 27. 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Question_27 {
    public static void main(String[] args) {

    }

    private TreeNode mirrorBinarryTree(TreeNode root) {
        if (root == null)
            return null;

        this.swapTreeNode(root);

        this.mirrorBinarryTree(root.left);
        this.mirrorBinarryTree(root.right);

        return root;
    }

    private void swapTreeNode(TreeNode pNode) {
        TreeNode tempNode;
        tempNode = pNode.left;
        pNode.left = pNode.right;
        pNode.right = tempNode;
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
