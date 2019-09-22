package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 40. 最小的 K 个数
 */
public class Question_40 {
    public static void main(String[] args) {
        int[][] testInstances = {{3, 2, 4, 2, 5, 2, 3}, {1, 2, 2}, {1, 2, 3, 2, 4, 2, 5, 2, 3}};

        Question_40 question_40 = new Question_40();
        for (int[] testInstance : testInstances) {
            System.out.println(question_40.findKthLeastNumber(testInstance, 3));
            System.out.println(question_40.findKthLeastNumbersWithMaxHeap(testInstance, 3));
        }
    }

    // 方法一：应用快速选择算法，会修改原始数组，时间复杂度 O(N)
    private ArrayList<Integer> findKthLeastNumber(int[] numbers, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (k > numbers.length)
            return resultList;

        int start = 0, end = numbers.length - 1;
        int targetIndex = k -1;
        int index = this.partition(numbers, start, end);

        while (index != targetIndex) {
            if (index < targetIndex)
                index = this.partition(numbers, index + 1, end);
            else
                index = this.partition(numbers, start, index - 1);
        }

        for (int i = 0; i < index + 1; i++)
            resultList.add(numbers[i]);

        return resultList;
    }

    // 方法二：使用大根堆（红黑树，最大平衡性，红黑树中查找、删除、插入时间复杂度均为 O(logK)）查找最小的k个数字，适用于海量数据查找，且不会修改原始数组，时间复杂度 O(N * logK) + O(K)
    // 默认为最小堆，重要方法：add, remove, peek, pool.
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 初始堆大小
    private static final int INIT_SIZE_OF_HEAP = 11;
    // 使用 Lambda 函数实现重写 comparator 方法,实现最大堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(INIT_SIZE_OF_HEAP, (o1, o2) -> o2 - o1);
    /*
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(INIT_SIZE_OF_HEAP, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 - o1 > 0)
                return 1;
            else if (o2 - o1 < 0)
                return -1;
            else
                return 0;
        }
    });
    */
    private ArrayList<Integer> findKthLeastNumbersWithMaxHeap(int[] numbers, int k) {
        ArrayList<Integer> resultList;

        if (numbers == null || k > numbers.length || k < 0)
            return new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int number : numbers) {
            maxHeap.add(number);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        resultList = new ArrayList<>(maxHeap);

        return resultList;
    }

    private int partition(int[] numbers, int start, int end) {
        if (start > end) {
            System.out.println("error input data.");
            return -1;
        }

        int pivot = numbers[start];

        while (start < end) {
            while (start < end && numbers[end] >= pivot)
                end--;
            if (start < end)
                numbers[start++] = numbers[end];
            while (start < end && numbers[start] <= pivot)
                start++;
            if (start < end)
                numbers[end--] = numbers[start];
        }

        numbers[start] = pivot;
        return start;
    }
}
