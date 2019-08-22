package priv.algorithm.coding_interviews;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 6. 从尾到头打印链表
 * 从尾到头反过来打印出每个结点的值。
 *
 * 测试用例：(1->2->3->4, 4->3->2->1), (,)
 */
public class Question_6 {

    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3, 4}, {66}, {}};
        Question_6 question_6 = new Question_6();

        for (int[] number: numbers) {
            ListNode listNode = question_6.createList(number);
            question_6.printListFromHeadToTail(listNode);
            question_6.printListFromTailToHead(listNode);
//            question_6.printListFromTailToHeadByStack(listNode);
//            question_6.printListFromTailToHeadByRecusion(listNode);

        }
    }

    public ListNode createList(int[] numbers) {
        ListNode headNode = new ListNode(-1);
        ListNode p = headNode;

        for (int number: numbers){
            ListNode node = new ListNode(number);
            p.next = node;
            p = p.next;
        }
        // 返回不带头节点的链表
        return headNode.next;
    }

    public void printListFromHeadToTail(ListNode listNode) {
        ListNode p = listNode;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList<Integer>();

        // 头插法反转链表
        ListNode headNode = new ListNode(-1);
        ListNode p = listNode;

        while (p != null) {
            ListNode pNext = p.next;
            p.next = headNode.next;
            headNode.next = p;
            p = pNext;
        }
        this.printListFromHeadToTail(headNode.next);

        p = headNode.next;
        while (p != null){
            arrayList.add(p.val);
            p = p.next;
        }

        return arrayList;
    }

    public void printListFromTailToHeadByStack(ListNode listNode) {
        Stack stack = new Stack();
        ListNode p = listNode;

        while (p != null){
            stack.push(p.val);
            p = p.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void printListFromTailToHeadByRecusion(ListNode listNode) {
        ListNode p = listNode;

        if (p != null) {
            this.printListFromTailToHeadByRecusion(p.next);
            System.out.println(p.val);
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