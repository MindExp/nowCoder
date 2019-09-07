package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Question_213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_213 question_213 = new Question_213();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            String[] strArray = str.split(",");
            int arrayLength = strArray.length;
            int[] array = new int[arrayLength];

            for (int index = 0; index < arrayLength; index++) {
                array[index] = Integer.parseInt(strArray[index]);
            }

            int maxOne = question_213.robMaxMoney(array, 0 , arrayLength - 2);
            int maxTwo = question_213.robMaxMoney(array, 1, arrayLength - 1);
            int maxMoney = Math.max(maxOne, maxTwo);
            System.out.println(maxMoney);
        }
    }

    private int robMaxMoney(int[] array, int start, int end) {
        int preMax = 0, currentMax = 0;

        for (int index = start; index <= end; index++) {
            int temp = currentMax;
            currentMax = Math.max(preMax + array[index], currentMax);
            preMax = temp;
        }

        return currentMax;
    }
}
