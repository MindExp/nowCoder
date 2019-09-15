package priv.algorithm.coding_interviews;

import java.util.LinkedList;

/**
 * 68. 树中两个节点的最低公共祖先
 */
public class Question_68 {
    public static void main(String[] args) {
        int[] pre = {6, 5, 4, 7, 2, 3};
        int[] in = {5, 4, 6, 2, 7, 3};
        Question_68 question_68 = new Question_68();

        TreeNode root = question_68.reConstructBinaryTree(pre, in);
        TreeNode[] targetNode1Array = {root, root.left, root.left};
        TreeNode[] targetNode2Array = {root, root.left.right, root.right.left};

        for (int index = 0; index < targetNode1Array.length; index++) {
            TreeNode resultNode = question_68.getFirstCommonAncestorNodeInBinaryTree(
                    root, targetNode1Array[index], targetNode2Array[index]);
            System.out.println(resultNode.val);
        }

    }

    private TreeNode getFirstCommonAncestorNodeInBinaryTree(TreeNode root, TreeNode targetNode1, TreeNode targetNode2) {
        ListNode pHead1 = this.getFirstAction(root, targetNode1);
        ListNode pHead2 = this.getFirstAction(root, targetNode2);

        return this.getFirstCommonNodeInList(pHead1, pHead2);
    }

    private ListNode getFirstAction(TreeNode root, TreeNode targetNode) {
        if (root == null || targetNode == null)
            return null;
        ListNode pHead = new ListNode(null);

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.addLast(pNode);

                if (pNode == targetNode)
                    // stack 构造存在问题
                    pHead = this.constructList(stack);

                pNode = pNode.left;
            }else {
                pNode = stack.pollLast();
                pNode = pNode.right;
            }
        }

        return pHead;
    }

    // 创建带头节点链表
    private ListNode constructList(LinkedList stack) {
        ListNode pHead = new ListNode(null), pNode = pHead;
        int stackSize = stack.size();

        for (int index = stackSize - 1; index >= 0; index--) {
            ListNode listNode = new ListNode((TreeNode) stack.get(index));
            pNode.next = listNode;
            pNode = pNode.next;
        }
        return pHead.next;
    }

    /**
     * 寻找两个链表第一个公共结点
     * @param pNode1
     * @param pNode2
     * @return
     */
    private TreeNode getFirstCommonNodeInList(ListNode pNode1, ListNode pNode2) {
        TreeNode firstCommonNode = null;
        if (pNode1 == null || pNode2 == null)
            return firstCommonNode;

        while (pNode1.treeNode != pNode2.treeNode) {
            pNode1 = pNode1.next != null ? pNode1.next : pNode2;
            pNode2 = pNode2.next != null ? pNode2.next : pNode1;
        }
        firstCommonNode = pNode1.treeNode;
        return firstCommonNode;
    }

    /**
     * 二叉查找树最低公共祖先
     * @param root
     * @param pNode1
     * @param pNode2
     * @return
     */
    private TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode root, TreeNode pNode1, TreeNode pNode2) {
        TreeNode lowestAncestorNode = null, pNode = root;
        if (root == null)
            return lowestAncestorNode;

        while (pNode != null) {
            if (pNode1.val < pNode.val && pNode2.val < pNode.val)
                pNode = pNode.left;
            else if (pNode1.val > pNode.val && pNode2.val > pNode.val)
                pNode = pNode.right;
            else {
                lowestAncestorNode = pNode;
                break;
            }
        }

        return lowestAncestorNode;
    }

    private class ListNode {
        TreeNode treeNode;
        ListNode next = null;

        public ListNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 依据前序与中序遍历序列，创建二叉树
     * @param pre
     * @param in
     * @return
     */
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
}
