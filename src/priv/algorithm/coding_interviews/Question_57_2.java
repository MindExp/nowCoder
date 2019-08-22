package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 * 题目描述：输出所有和为 S 的连续正数序列。
 */
public class Question_57_2 {
    public static void main(String[] args) {
        int[] testInstances = {9, 10, 20, 50, 100, 1000, 10000};
        Question_57_2 question_57_2 = new Question_57_2();

        for (int testInstance : testInstances) {
            ArrayList<ArrayList<Integer>> resultLists = question_57_2.findContinuesSequntial(testInstance);
            for (ArrayList<Integer> result : resultLists) {
                int start = result.get(0), end = result.get(1);
                while (start <= end) {
                    System.out.print(String.valueOf(start) + " ");
                    start++;
                }
                System.out.println();
            }
        }
    }

    /**
     * 双指针法：时间复杂度：O(N)，空间复杂度 O(1)
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> findContinuesSequntial(int target) {
        int left = 1, right = 1, currentSum;
        ArrayList<ArrayList<Integer>> resultLists = new ArrayList<>();
        ArrayList<Integer> result;

        while ((left << 1) < target) {
            currentSum = this.sumSequentialNumbers(left, right);
            if (currentSum > target) {
                left++;
            } else if (currentSum < target) {
                right++;
            } else {
                result = new ArrayList<>();
                result.add(left);
                result.add(right);
                resultLists.add(result);
                left++;
            }
        }

        return resultLists;
    }

    private int sumSequentialNumbers(int left, int right) {
        int numbers = right - left + 1;

        return numbers * (left + right) / 2;
    }
}
