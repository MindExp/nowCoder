package priv.algorithm.coding_interviews;

/**
 * 24. 反转链表
 */
public class Question_24 {
    public static void main(String[] args) {

    }

    // 使用头插法反转链表
    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            head.next = nextNode.next;
            nextNode.next = headNode.next;
            headNode.next = nextNode;
            nextNode = head.next;
        }

        return headNode.next;
    }

    // 使用头插法反转链表
    private ListNode reverseListNodeByHeadInsert(ListNode head) {
        ListNode headNode = new ListNode(-1);
        ListNode nextNode;

        while (head != null) {
            nextNode = head.next;
            head.next = headNode.next;
            headNode.next = head;
            head = nextNode;
        }

        return headNode.next;
    }

    private ListNode reverseListNodeByRecursion(ListNode head) {
        if (head == null || head.next ==null)
            return head;

        ListNode nextNode = head.next;
        head.next = null;
        ListNode reversenListNode = this.reverseListNodeByRecursion(nextNode);
        nextNode.next = head;

        return reversenListNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
