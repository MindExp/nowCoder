package priv.algorithm.coding_interviews;

/**
 * 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Question_36 {
    private TreeNode headNode;
    private TreeNode preNode;

    public static void main(String[] args) {

    }

    private TreeNode convertBinarySearchTree2LinkList(TreeNode root) {
        this.convertByInOrderSearch(root);

        return this.headNode;
    }

    // 使用中序遍历创建双端链表
    private void convertByInOrderSearch(TreeNode rootNode) {
        if (rootNode == null)
            return;

        this.convertByInOrderSearch(rootNode.left);
        // 创建双端链表
        if (preNode == null)
            preNode = rootNode.left;
        else
            preNode.right = rootNode;
        rootNode.left = preNode;
        preNode = rootNode;

        if (headNode == null)
            headNode = rootNode;

        this.convertByInOrderSearch(rootNode.right);
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
