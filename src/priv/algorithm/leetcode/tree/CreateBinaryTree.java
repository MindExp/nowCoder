package priv.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateBinaryTree {
    /**
     * 方案一：已知二叉树前序序列与中序序列—>创建二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    private TreeNode createTreeByPreOrderAndInOrder(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)
            return null;

        return this.createActionInPreOrderAndInOrder(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    private TreeNode createActionInPreOrderAndInOrder(int[] preOrder, int preStart, int preEnd,
                                                      int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        int rootIndex = 0;
        for (int index = inStart; index <= inEnd; index++) {
            if (inOrder[index] == preOrder[preStart]) {
                rootIndex = index;
                break;
            }
        }
        int leftDistance = rootIndex - inStart;
        root.left = this.createActionInPreOrderAndInOrder(preOrder, preStart + 1, preStart + leftDistance,
                inOrder, inStart, rootIndex - 1);
        root.right = this.createActionInPreOrderAndInOrder(preOrder, preStart + leftDistance + 1, preEnd,
                inOrder, rootIndex + 1, inEnd);
        return root;
    }

    /**
     * 方案二：已知二叉树中序序列与后序序列—>创建二叉树
     * @param inOrder
     * @param postOrder
     * @return
     */
    private TreeNode createTreeByInOrderAndPostOrder(int[] inOrder, int[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length)
            return null;
        return this.createActionInInOrderAndPostOrder(inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1);
    }

    private TreeNode createActionInInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd,
                                                       int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int indexRoot = 0;
        for (int index = inStart; index <= inEnd; index++) {
            if (inOrder[index] == postOrder[postEnd]) {
                indexRoot = index;
                break;
            }
        }
        int leftDistance = indexRoot - inStart;
        root.left = this.createActionInInOrderAndPostOrder(inOrder, inStart, indexRoot - 1,
                postOrder, postStart, postStart + leftDistance - 1);
        root.right = this.createActionInInOrderAndPostOrder(inOrder, indexRoot + 1, inEnd,
                postOrder, postStart + leftDistance, postEnd - 1);
        return root;
    }

    /**
     * 方案三：使用数组数据，创建完全二叉树
     * @param array
     * @return
     */
    private TreeNode createPerfectBinaryTreeActionByArray(String[] array) {
        if (array == null || array.length == 0)
            return null;

        ArrayList<TreeNode> treeNodesList = new ArrayList<>();
        treeNodesList.add(new TreeNode(Integer.parseInt(array[0])));
        for (int index = 1; index < array.length; index++) {
            if (array[index].equals("null"))
                continue;
            TreeNode currentNode = new TreeNode(Integer.parseInt(array[index]));
            int parentNodeIndex = (index + 1) >> 1;

            if ((index + 1) % 2 == 0)
                treeNodesList.get(parentNodeIndex - 1).left = currentNode;
            else
                treeNodesList.get(parentNodeIndex - 1).right = currentNode;
            treeNodesList.add(currentNode);
        }
        return treeNodesList.get(0);
    }

    public TreeNode createBinaryTreeByPreOrderAndInOrder() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strPreOrderArray = scanner.nextLine().trim().split(" ");
            String[] strInOrderArray = scanner.nextLine().trim().split(" ");
            int[] preOrder = this.convertStrArray2IntArray(strPreOrderArray);
            int[] inOrder = this.convertStrArray2IntArray(strInOrderArray);
            return this.createTreeByPreOrderAndInOrder(preOrder, inOrder);
        }
        return null;
    }

    public TreeNode createBinaryTreeByInOrderAndPostOrder() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strInOrderArray = scanner.nextLine().trim().split(" ");
            String[] strPostOrderArray = scanner.nextLine().trim().split(" ");
            int[] inOrder = this.convertStrArray2IntArray(strInOrderArray);
            int[] postOrder = this.convertStrArray2IntArray(strPostOrderArray);
            return this.createTreeByInOrderAndPostOrder(inOrder, postOrder);
        }
        return null;
    }


    public TreeNode createPerfectBinaryTreeByArray() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strArray = scanner.nextLine().trim().split(" ");
            return this.createPerfectBinaryTreeActionByArray(strArray);
        }
        return null;
    }

    /**
     * 整数字符串数组转换为整型数组
     * @param strArray
     * @return
     */
    private int[] convertStrArray2IntArray(String[] strArray) {
        if (strArray == null)
            return null;
        int[] array = new int[strArray.length];
        for (int index = 0; index < strArray.length; index++)
            array[index] = Integer.parseInt(strArray[index]);
        return array;
    }
}
