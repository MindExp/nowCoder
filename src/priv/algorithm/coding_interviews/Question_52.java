package priv.algorithm.coding_interviews;


/**
 * 52. 两个链表的第一个公共结点
 */
public class Question_52 {
    public static void main(String[] args) {

    }

    /**
     * 方案一：a + c + b = b + c + a
     * @param firstHead
     * @param secondHead
     * @return
     */
    private ListNode getFirstCommonNodeV1(ListNode firstHead, ListNode secondHead) {
        ListNode firstNode = firstHead, secondNode = secondHead;
        ListNode commonNode;

        while (firstNode != secondNode) {
            firstNode = (firstNode == null) ? secondHead : firstNode.next;
            secondNode = (secondNode == null) ? firstHead : secondNode.next;
        }
        commonNode = firstNode;

        return commonNode;
    }

    /**
     * 方案二：先分别统计两个链表长度，在求差，进而找到公共节点
     * @param firstHead
     * @param secondHead
     * @return
     */
    private ListNode getFirstCommonNodeV2(ListNode firstHead, ListNode secondHead) {
        ListNode firstNode = firstHead, secondNode = secondHead, commonNode;
        int counterFirst = 0, counterSecond = 0;

        while (firstNode != null) {
            counterFirst++;
            firstNode = firstNode.next;
        }
        while (secondNode != null) {
            counterSecond++;
            secondNode = secondNode.next;
        }

        int diffrence = counterFirst - counterSecond;
        diffrence = (diffrence > 0) ? diffrence : -diffrence;

        if (counterFirst > counterSecond) {
            firstNode = firstHead;
            secondNode = secondHead;
        } else {
            firstNode = secondHead;
            secondNode = firstHead;
        }


        for (int i = 0; i < diffrence; i++)
            firstNode = firstNode.next;

        while (firstNode != secondNode) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        commonNode = firstNode;

        return commonNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
