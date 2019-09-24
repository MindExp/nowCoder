package priv.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(N)。
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Question_128 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_128 question_128 = new Question_128();
        while (scanner.hasNextLine()) {
            String[] strArray = scanner.nextLine().trim().split(" ");
            int[] array = new int[strArray.length];

            for (int index = 0; index < array.length; index++) {
                array[index] = Integer.parseInt(strArray[index]);
            }

            int maxContinuous = question_128.longestContinuousNumbers(array);
            System.out.println(maxContinuous);
        }
    }

    /**
     * 暴力求解，时间复杂度 O(N^3)
     * @param array
     * @return
     */
    public int solutionByForce(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int finalResult = Integer.MIN_VALUE;
        for (int current : array) {
            int currentResult = 1;
            while (this.contains(array, current + 1)) {
                currentResult++;
                current++;
            }
            finalResult = Math.max(finalResult, currentResult);
        }
        return finalResult;
    }

    private boolean contains(int[] array, int target) {
        for (int current : array) {
            if (current == target)
                return true;
        }
        return false;
    }

    /**
     * 常规方案，时间复杂度 O(N*log(N))
     * @param array
     * @return
     */
    public int solutionBySort(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        Arrays.sort(array);

        int currentCounter = 1, finalCounter = currentCounter;
        for (int index = 1; index < array.length; index++) {
            if (array[index] != array[index - 1]) {
                if (array[index] == array[index - 1] + 1) {
                    currentCounter += 1;
                } else {
                    finalCounter = Math.max(currentCounter, finalCounter);
                    currentCounter = 1;
                }
            }
        }
        return Math.max(currentCounter, finalCounter);
    }

    /**
     * 哈希表算法，时间复杂度 O(N+N) 即 O(N)，空间复杂度 O(N)
     * @param array
     * @return
     */
    public int longestContinuousNumbers(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        HashSet<Integer> itemSet = new HashSet<>();
        for (int current : array) {
            itemSet.add(current);
        }
        int finalCounter = Integer.MIN_VALUE;
        for (int current : array) {
            // current 作为序列起始元素
            if (!itemSet.contains(current - 1)) {
                int currentCounter = 1;
                while (itemSet.contains(current + 1)) {
                    currentCounter++;
                    current++;
                }
                finalCounter = Math.max(currentCounter, finalCounter);
            }
        }
        return finalCounter;
    }
}
