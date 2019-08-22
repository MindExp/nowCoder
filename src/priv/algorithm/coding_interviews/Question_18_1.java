package priv.algorithm.coding_interviews;

/**
 * 18.1 在 O(1) 时间内删除链表节点
 */
public class Question_18_1 {
    public static void main(String[] args) {

    }

    private LinkedListNode deleteNodeInLinkedList(LinkedListNode headNode, LinkedListNode deleteNode) {
        if (headNode == null || headNode.next == null || deleteNode == null)
            return null;

        LinkedListNode nextNode, preNode;
        if (deleteNode.next != null){
            nextNode = deleteNode.next;
            deleteNode.val = nextNode.val;
            deleteNode.next = nextNode.next;
            nextNode.next = null;
        }else {
            preNode = headNode;
            while (preNode.next != deleteNode)
                preNode = preNode.next;
            preNode.next = null;
        }
        return headNode;
    }

    private class LinkedListNode {
        int val;
        LinkedListNode next = null;

        public LinkedListNode(int val) {
            this.val = val;
        }
    }
}
