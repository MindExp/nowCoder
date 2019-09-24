package priv.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintBinaryTree {
    private TreeNode root;
    private ArrayList<Integer> printList;

    public PrintBinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByPreOrder_Recursion(TreeNode root) {
        if (root != null) {
            this.printList.add(root.val);
            this.printBinaryTreeByPreOrder_Recursion(root.left);
            this.printBinaryTreeByPreOrder_Recursion(root.right);
        }
    }

    /**
     * 前序非递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByPreOrder_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                this.printList.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    /**
     * 中序递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByInOrder_Recursion(TreeNode root) {
        if (root != null) {
            this.printBinaryTreeByInOrder_Recursion(root.left);
            this.printList.add(root.val);
            this.printBinaryTreeByInOrder_Recursion(root.right);
        }
    }

    /**
     * 中序非递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByInOrder_Stack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                this.printList.add(pNode.val);
                pNode = pNode.right;
            }
        }
    }

    /**
     * 后续递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByPostOrder_Recursion(TreeNode root) {
        if (root != null) {
            this.printBinaryTreeByPostOrder_Recursion(root.left);
            this.printBinaryTreeByPostOrder_Recursion(root.right);
            this.printList.add(root.val);
        }
    }

    /**
     * 后续非递归打印二叉树结点
     * @param root
     */
    private void printBinaryTreeByPostOrder_Stack(TreeNode root) {
        TreeNode pNode = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;

        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }
        while (!stack.isEmpty()) {
            pNode = stack.pop();
            // 访问当前结点条件
            if (pNode.right == null || pNode.right == lastVisited) {
                this.printList.add(pNode.val);
                lastVisited = pNode;
            } else {
                // 若当前 pNode 不能被访问则重新入栈
                stack.push(pNode);
                pNode = pNode.right;
                while (pNode != null) {
                    stack.push(pNode);
                    pNode = pNode.left;
                }
            }
        }
    }

    private void printAction() {
        int listSize = this.printList.size();
        for (int index = 0; index < listSize - 1; index++)
            System.out.print(this.printList.get(index) + " ");
        System.out.println(this.printList.get(listSize - 1));
    }

    public void printBinaryTreeByPreOrder_Recursion(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByPreOrder_Recursion(root);
        this.printAction();
    }

    public void printBinaryTreeByPreOrder_Stack(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByPreOrder_Stack(root);
        this.printAction();
    }

    public void printBinaryTreeByInOrder_Recursion(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByInOrder_Recursion(root);
        this.printAction();
    }

    public void printBinaryTreeByInOrder_Stack(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByInOrder_Stack(root);
        this.printAction();
    }

    public void printBinaryTreeByPostOrder_Recursion(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByPostOrder_Recursion(root);
        this.printAction();
    }

    public void printBinaryTreeByPostOrder_Stack(){
        this.printList = new ArrayList<>();
        this.printBinaryTreeByPostOrder_Stack(root);
        this.printAction();
    }
}
