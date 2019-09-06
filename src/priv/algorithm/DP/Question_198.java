package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Question_198 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_198 question_198 = new Question_198();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            String[] strArray = str.split(",");
            int arrayLength = strArray.length;
            int[] array = new int[arrayLength];

            for (int index = 0; index < arrayLength; index++) {
                array[index] = Integer.parseInt(strArray[index]);
            }

            int maxMoney = question_198.robMaxMoney(array);
            System.out.println(maxMoney);
        }
    }

    /**
     * 动态规划：dp[i] = max(dp[i - 2] + array[i], dp[i - 1])
     * @param array
     * @return
     */
    private int robMaxMoney(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int arrayLength = array.length, preMax = 0, currentMax = 0;

        for (int index = 0; index < arrayLength; index++) {
            int temp = currentMax;
            currentMax = Math.max(preMax + array[index], currentMax);
            preMax = temp;
        }

        return currentMax;
    }
}
