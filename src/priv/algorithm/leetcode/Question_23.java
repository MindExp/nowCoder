package priv.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 23. 合并 k 个有序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Question_23 {
    public static void main(String[] args) {

    }

    /**
     * 使用小顶堆合并 k 个有序链表，时间复杂度 O(N*log(K))，空间复杂度 O(N) + O(K)
     * @param lists
     * @return
     */
    private ListNode mergeKListsV1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        // 小顶堆—>最大堆，使用匿名函数会极大增加运行时间
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, ((o1, o2) -> {
            if (o1.val > o2.val) return 1;
            else if (o1.val == o2.val) return 0;
            else return -1;
        }));
        for (ListNode headNode : lists)
            if (headNode != null)
                minHeap.add(headNode);

        ListNode head = new ListNode(-1), pNode = head;
        while (!minHeap.isEmpty()) {
            pNode.next = minHeap.poll();
            pNode = pNode.next;

            if (pNode.next != null)
                minHeap.add(pNode.next);
        }
        return head.next;
    }

    /**
     * 归并思想合并 k 个有序链表，时间复杂度 O(N*log(K))，空间复杂度 O(N)
     * @param lists
     * @return
     */
    private ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return this.merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int middle = (left + right) / 2;
        ListNode listLeft = this.merge(lists, left, middle);
        ListNode listRight = this.merge(lists, middle + 1, right);

        return this.mergeTwoList(listLeft, listRight);
    }

    private ListNode mergeTwoList(ListNode listOne, ListNode listTwo) {
        if (listOne == null) return listTwo;
        if (listTwo == null) return listOne;

        if (listOne.val < listTwo.val) {
            listOne.next = this.mergeTwoList(listOne.next, listTwo);
            return listOne;
        } else {
            listTwo.next = this.mergeTwoList(listOne, listTwo.next);
            return listTwo;
        }
    }

    private class ListNode {
        private int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
