package priv.algorithm.coding_interviews;

/**
 * 23. 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 */
public class Question_23 {
    public static void main(String[] args) {

    }

    /*
    使用快慢指针判断链表中是否存在环
    1. 不存在环，返回 null
    2. 存在环，计数链表中环中节点个数，然后使用前后指针即可找到入口节点
     */
    private ListNode enterNodeOfCycleInListNode(ListNode headNode) {
        if (headNode == null || headNode.next ==null || headNode.next.next == null)
            return null;
        // 至少三个节点才可能存在环
        ListNode enterNode = null, slowerNode = headNode, fasterNode = headNode.next.next;
        while (fasterNode != null && fasterNode != slowerNode) {
            slowerNode = slowerNode.next;
            fasterNode = fasterNode.next;
            if (fasterNode.next != null)
                fasterNode = fasterNode.next;
            else
                break;
        }

        // 链表中存在环
        if (fasterNode == slowerNode) {
            ListNode q1Node = headNode, q2Node = headNode;
            ListNode pNode = slowerNode.next;

            // 若环中存在 n 个节点，则 q1Node 向前移动 n 步
            while (pNode != slowerNode) {
                pNode = pNode.next;
                q1Node = q1Node.next;
            }
            q1Node = q1Node.next;
            // 找到入口节点
            while (q1Node != q2Node) {
                q1Node = q1Node.next;
                q2Node = q2Node.next;
            }
            enterNode = q2Node;
        }

        return enterNode;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
