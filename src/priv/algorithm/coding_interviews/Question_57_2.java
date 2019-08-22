package priv.algorithm.coding_interviews;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 * 题目描述：输出所有和为 S 的连续正数序列。
 */
public class Questoin_57_2 {
    public static void main(String[] args) {
        int[] testInstances = {10, 20, 50, 100};

    }

    private ArrayList<Integer> findContinuesSequntial(int target) {
        int left = 1, right = 1, currentSum;

        while ((left << 1) < target) {
            currentSum = this.sumSequentialNumbers(left, right);
            if (currentSum > target) {
                left++;
            } else if (currentSum < target) {
                right++;
            } else {

            }
        }
    }

    private int sumSequentialNumbers(int left, int right) {
        int numbers = right - left + 1;

        return numbers * (left + right) / 2;
    }
}
