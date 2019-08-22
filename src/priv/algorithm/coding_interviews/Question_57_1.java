package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 和为 S 的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
 */
public class Question_57_1 {
    public static void main(String[] args) {
        int[][] testInstances = {{1, 2, 3, 4, 6, 7, 8}};
        int [] sumTarget = {10, 9, 8};
        Question_57_1 question_57_1 = new Question_57_1();

        for (int[] testInstance : testInstances) {
            for (int target : sumTarget) {
                ArrayList resultList = question_57_1.findNumbersWithSum(testInstance, target);
                for (Object result : resultList)
                    System.out.println(result);
            }
        }
    }

    /**
     * 双指针法：时间复杂度：O(N)，空间复杂度 O(1)
     * @param numbers
     * @param target
     * @return
     */
    private ArrayList<Integer> findNumbersWithSum(int[] numbers, int target) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (numbers == null || numbers.length < 2)
            return resultList;

        int left = 0, right = numbers.length - 1, finalAccumulation = Integer.MAX_VALUE, currentAccumulation;
        int firstIndex = -1, secondIndex = -1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum > target) {
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                currentAccumulation = numbers[left] * numbers[right];
                if (currentAccumulation < finalAccumulation) {
                    finalAccumulation = currentAccumulation;
                    firstIndex = left;
                    secondIndex = right;
                }
                left++;
                right--;
            }
        }
        if (firstIndex >= 0) {
            resultList.add(numbers[firstIndex]);
            resultList.add(numbers[secondIndex]);
        }

        return resultList;
    }
}
