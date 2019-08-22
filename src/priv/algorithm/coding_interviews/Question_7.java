package priv.algorithm.coding_interviews;

import java.util.Stack;

/**
 *7. 重建二叉树
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Question_7 {
    public static void main(String[] args) {
        int[] pre = {6, 5, 4, 7, 2, 3};
        int[] in = {5, 4, 6, 2, 7, 3};
        Question_7 question_7 = new Question_7();

        TreeNode root = question_7.reConstructBinaryTree(pre, in);
        question_7.printBinaryTreeByPreOrder(root);
        question_7.printBinaryTreeByPreOrder_Stack(root);
        question_7.printBinaryTreeByInOrder(root);
        question_7.printBinaryTreeByInOrder_Stack(root);
        question_7.printBinaryTreeByPostOrder(root);
        question_7.printBinaryTreeByPostOrder_Stack(root);
    }

    private TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root;

        if (pre == null || in == null)
            return null;
        if (pre.length != in.length){
            // 输入错误标记
            System.out.println("error input data, can not construct binary tree.");
            return null;
        }

        root = this.reConstructBinaryTreeV1(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTreeV1(int [] pre, int preStart, int preEnd, int [] in, int inStart, int inEnd) {
        // 注意边界条件
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int indexOfRootNodeInInorder = 0;

        for (int index = inStart; index <= inEnd; index++) {
            if (pre[preStart] == in[index]) {
                indexOfRootNodeInInorder = index;
                break;
            }
        }

        int leftDistance = indexOfRootNodeInInorder - inStart;
        root.left = this.reConstructBinaryTreeV1(pre, preStart + 1, preStart + leftDistance,
                in, inStart, indexOfRootNodeInInorder - 1);
        root.right = this.reConstructBinaryTreeV1(pre, preStart + leftDistance + 1, preEnd,
                in, indexOfRootNodeInInorder + 1, inEnd);

        return root;
    }

    private TreeNode reConstructBinaryTreeV2(int [] pre, int preStart, int preEnd, int [] in, int inStart, int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);
        // 注意边界条件
        if (preStart == preEnd || inStart == inEnd)
            return root;

        int indexOfRootNodeInInorder = 0;
        for (int index = inStart; index <= inEnd; index++) {
            if (in[index] == pre[inStart]) {
                indexOfRootNodeInInorder = index;
                break;
            }
        }

        int leftDistance = indexOfRootNodeInInorder - inStart;
        if (leftDistance > 0 )
            root.left = this.reConstructBinaryTreeV2(pre, preStart + 1, preStart + leftDistance,
                    in, inStart, indexOfRootNodeInInorder - 1);
        if (indexOfRootNodeInInorder < inEnd)
            root.right = this.reConstructBinaryTreeV2(pre, preStart + leftDistance + 1, preEnd,
                    in, indexOfRootNodeInInorder + 1, inEnd);

        return root;
    }

    /**
     * 递归前序遍历二叉树
     * @param root
     */
    private void printBinaryTreeByPreOrder(TreeNode root) {
        if (root != null){
            System.out.println(root.val);
            this.printBinaryTreeByPreOrder(root.left);
            this.printBinaryTreeByPreOrder(root.right);
        }
    }

    /**
     * 非递归前序遍历二叉树
     * @param root
     */
    private void printBinaryTreeByPreOrder_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null){
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    /**
     * 递归中序遍历二叉树
     * @param root
     */
    private void printBinaryTreeByInOrder(TreeNode root) {
        if (root != null){
            this.printBinaryTreeByInOrder(root.left);
            System.out.println(root.val);
            this.printBinaryTreeByInOrder(root.right);
        }
    }

    /**
     * 非递归中序遍历二叉树
     * @param root
     */
    private void printBinaryTreeByInOrder_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null){
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                System.out.println(pNode.val);
                pNode = pNode.right;
            }
        }
    }

    /**
     * 递归后续遍历二叉树
     * @param root
     */
    private void printBinaryTreeByPostOrder(TreeNode root) {
        if (root != null){
            this.printBinaryTreeByPostOrder(root.left);
            this.printBinaryTreeByPostOrder(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 非递归后续遍历二叉树
     * @param root
     */
    private void printBinaryTreeByPostOrder_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode pNode = root;
        TreeNode lastVisitedNode = null;

        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }

        while (!stack.isEmpty()) {
            pNode = stack.pop();
            // 当且仅当 pNode 右节点为空或者右子树已经访问过才访问 pNode
            if (pNode.right != null && pNode.right != lastVisitedNode) {
                stack.push(pNode);
                pNode = pNode.right;
                while (pNode != null) {
                    stack.push(pNode);
                    pNode = pNode.left;
                }
            }else {
                System.out.println(pNode.val);
                lastVisitedNode = pNode;
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
}