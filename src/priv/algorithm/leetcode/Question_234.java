package priv.algorithm.leetcode;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 */
public class Question_234 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针判定是否为回文链表
     * @param head
     * @return
     */
    private boolean isPalindromeList(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head.next;
        // 寻找链表中间结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode qNode = slow.next;

        if (fast != null)
            slow = slow.next;

        // 带头结点头插法，翻转链表前半部分
        ListNode headNode = new ListNode(-1), pNode = head;
        while (pNode != slow) {
            ListNode pNextNode = pNode.next;
            pNode.next = headNode.next;
            headNode.next = pNode;
            pNode = pNextNode;
        }
        pNode = headNode.next;
        return this.isSameValueList(pNode, qNode);
    }

    /**
     * 判定两个链表是否相同/值
     * @param pHead
     * @param qHead
     * @return
     */
    private boolean isSameValueList(ListNode pHead, ListNode qHead) {
        boolean result = true;
        ListNode pNode = pHead, qNode = qHead;

        while (pNode != null && qNode != null) {
            if (pNode.val != qNode.val) {
                result = false;
                break;
            }
            pNode = pNode.next;
            qNode = qNode.next;
        }

        return result;
    }

    private class ListNode {
        private int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
