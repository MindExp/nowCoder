package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 59. 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class Question_59_1 {
    public static void main(String[] args) {
        int[][] testInstances = {{2, 3, 4, 2, 6, 2, 5, 1}, {23, 43, 2, 45, 15, 38, 30, 40, 29}};
        int[] windowSizes = {3, 4, 5, 100, 0, -1};
        Question_59_1 question_59_1 = new Question_59_1();

        for (int[] testInstance : testInstances) {
            for (int windowSize : windowSizes) {
                ArrayList<Integer> resultList = question_59_1.maxInWindowsV1(testInstance, windowSize);
                if (!question_59_1.invalidData) {
                    for (int result : resultList)
                        System.out.println(result);
                } else
                    System.out.println("invalid input data.");
            }
        }
    }

    /**
     * 掌握方案一：时间复杂度 O(N)，空间复杂度 O(k)
     * @param num
     * @param windowSize
     * @return
     */
    private ArrayList<Integer> maxInWindowsV1(int[] num, int windowSize) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (num == null || num.length < windowSize || windowSize <= 0)
            return resultList;

        // indexQueue 中 index 对应的值降序
        LinkedList<Integer> indexQueue = new LinkedList<>();
        int numLength = num.length;

        for (int index = 0; index < windowSize; index++) {
            while (!indexQueue.isEmpty() && num[index] >= num[indexQueue.getLast()])
                indexQueue.removeLast();
            // index 对应的值可能成为最大值
            indexQueue.addLast(index);
        }

        resultList.add(num[indexQueue.getFirst()]);

        for (int index = windowSize; index < numLength; index++) {
            while (!indexQueue.isEmpty() && num[index] >= num[indexQueue.getLast()])
                indexQueue.removeLast();

            if (!indexQueue.isEmpty() && (index - indexQueue.getFirst() + 1) > windowSize)
                indexQueue.removeFirst();

            indexQueue.addLast(index);
            resultList.add(num[indexQueue.getFirst()]);
        }

        return resultList;
    }

    private boolean invalidData = false;

    /**
     * 方案二：使用大顶堆实现，时间复杂度 O(N * log(k))，空间复杂度 O(k)
     * @param num
     * @param windowSize
     * @return
     */
    private ArrayList<Integer> maxInWindowsV2(int[] num, int windowSize) {
        this.invalidData = false;
        ArrayList<Integer> resultList = new ArrayList<>();
        // 边界检查
        if (num == null || num.length < windowSize || windowSize <= 0) {
            this.invalidData = true;
            return resultList;
        }

        // 大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int numLength = num.length;
        for (int index = 0; index < windowSize; index++)
            maxHeap.add(num[index]);

        resultList.add(maxHeap.peek());

        for (int index = windowSize; index < numLength; index++) {
            maxHeap.remove(num[index - windowSize]);
            maxHeap.add(num[index]);
            resultList.add(maxHeap.peek());
        }

        return resultList;
    }
}
