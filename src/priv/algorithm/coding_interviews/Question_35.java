package priv.algorithm.coding_interviews;

/**
 * 35. 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 */
public class Question_35 {
    public static void main(String[] args) {

    }

    private RandomListNode copyComplexityRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode headNode, qNode;
        RandomListNode pNode = head, nextNode;

        // 创建节点
        while (pNode != null) {
            qNode = new RandomListNode(pNode.label);
            qNode.next = pNode.next;
            pNode.next = qNode;
            pNode = qNode.next;
        }

        // 复制节点 random 指针
        pNode = head;
        while (pNode != null) {
            qNode = pNode.next;
            if (pNode.random != null)
                qNode.random = pNode.random.next;
            pNode = qNode.next;
        }

        // 断链
        headNode = head.next;
        pNode = head;
        while (pNode.next != null) {
            nextNode = pNode.next;
            pNode.next = nextNode.next;
            pNode = nextNode;
        }

        return headNode;
    }

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
}
