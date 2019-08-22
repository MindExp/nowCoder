package priv.algorithm.coding_interviews;

/**
 * 25. 合并两个排序的链表
 */
public class Question_25 {
    public static void main(String[] args) {

    }

    private ListNode mergeTwoSortedListNode(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode(-1);
        ListNode pNode = headNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pNode.next = list1;
                list1 = list1.next;
            }else {
                pNode.next = list2;
                list2 = list2.next;
            }
            pNode = pNode.next;
        }

        if (list1 != null)
            pNode.next = list1;
        if (list2 != null)
            pNode.next = list2;

        return headNode.next;
    }

    private void linkRemainingNode(ListNode headNode, ListNode remainHeadNode) {
        while (remainHeadNode != null) {
            headNode.next = remainHeadNode;
            remainHeadNode = remainHeadNode.next;
            headNode = headNode.next;
        }
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
