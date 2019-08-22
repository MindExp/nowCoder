package priv.algorithm.coding_interviews;

/**
 * 22. 链表中倒数第 K 个结点
 */
public class Question_22 {
    public static void main(String[] args) {

    }

    private ListNode findReversedKthListNode(ListNode headNode, int k) {
        if (headNode == null || k < 0)
            return null;

        ListNode kthNode, preNode = headNode, pNode = headNode;

        // 推荐解法：pNode 向后移动 k 步
        while (pNode != null && k-- > 0)
            pNode = pNode.next;

        if (k > 0)
            return null;

        while (pNode != null) {
            pNode = pNode.next;
            preNode = preNode.next;
        }
        kthNode = preNode;

        return kthNode;
    }

    private ListNode findKthNodeToTail(ListNode headNode, int k) {
        if (headNode == null || k < 0)
            return null;

        ListNode kthNode, preNode = headNode, pNode = headNode;

        // 推荐解法：pNode 向后移动 k 步
        while (pNode != null && k-- > 0)
            pNode = pNode.next;

        if (k > 0)
            return null;

        while (pNode != null) {
            pNode = pNode.next;
            preNode = preNode.next;
        }
        kthNode = preNode;

        return kthNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
