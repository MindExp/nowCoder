package priv.algorithm.coding_interviews;

/**
 * 18.2 删除有序链表中重复的结点
 */
public class Question_18_2 {
    public static void main(String[] args) {

    }

    private ListNode deleteDuplicatedNode(ListNode head) {
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode preNode = headNode, pNode = preNode.next;

        while (pNode != null) {
            // 扫描重复节点
            while (pNode.next != null && pNode.val == pNode.next.val)
                pNode = pNode.next;
            // 不存在重复节点
            if (pNode == preNode.next) {
                preNode = pNode;
                pNode = pNode.next;
            }else {
                preNode.next = pNode.next;
                pNode = pNode.next;
            }
        }

        return headNode.next;
    }

    private ListNode deleteDuplicatedNodeByRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pNode = head, nextNode;
        nextNode = head.next;

        if (pNode.val == nextNode.val) {
            while (nextNode != null && pNode.val == nextNode.val)
                nextNode = nextNode.next;
            pNode = this.deleteDuplicatedNodeByRecursion(nextNode);
        }else {
            pNode.next = this.deleteDuplicatedNodeByRecursion(nextNode);
        }
        return pNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
