package priv.algorithm.coding_interviews;

import java.util.PriorityQueue;

/**
 * 41.1 数据流中的中位数
 * 海量数据寻找中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Question_41_1 {

    public static void main(String[] args) {

    }

    private Double findMinddleNumber() {
        return this.getMedian();
    }

    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int count = 0;

    private void insertElement2Heap(Integer number) {
        count++;
        // 保证 leftMaxHeap 中元素 < rightMinHeap 中元素
        if (count % 2 == 0) {
            // count 为偶数时插入右边小根堆
            leftMaxHeap.add(number);
            rightMinHeap.add(leftMaxHeap.poll());
        }else {
            // count 为奇数时插入左边大根堆
            rightMinHeap.add(number);
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    private Double getMedian() {
        if (count % 2 == 0)
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        else
            return leftMaxHeap.peek().doubleValue();
    }
}
