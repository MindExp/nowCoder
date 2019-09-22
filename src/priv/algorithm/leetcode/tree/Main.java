package priv.algorithm.leetcode.tree;

/**
 * 先序：1 2 4 5 6 9 7 3 8
 * 中序：4 2 6 9 5 7 1 8 3
 * 后续：4 9 6 7 5 2 8 3 1
 */
public class Main {
    public static void main(String[] args) {
        CreateBinaryTree createBinaryTree = new CreateBinaryTree();
        TreeNode root = createBinaryTree.createBinaryTreeByInOrderAndPostOrder();

        PrintBinaryTree printBinaryTree = new PrintBinaryTree(root);
        printBinaryTree.printBinaryTreeByPostOrder_Recursion();
        printBinaryTree.printBinaryTreeByPostOrder_Stack();
    }
}
