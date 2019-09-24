package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 77_1. 最长公共子序列
 * 给定两个字符串，返回长公共子序列长度
 */
public class Question_77_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_77_1 question_771 = new Question_77_1();
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine().trim();
            String str2= scanner.nextLine().trim();
            int result = question_771.longestCommonSubSequentialLength(str1, str2);
            System.out.println(result);
        }
    }

    private boolean inValidData = false;

    /**
     * 动态规划求解：
     * 1）str1.charAt(i) != str2.charAt(j)， dp[i][j] = dp[i - 1][j - 1];
     * 2）str1.charAt(i) = str2.charAt(j)，dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
     * @param str1
     * @param str2
     * @return
     */
    private int longestCommonSubSequentialLength(String str1, String str2) {
        if (str1 == null || str2 == null) {
            this.inValidData = true;
            return 0;
        }

        int str1Length = str1.length(), str2Length = str2.length();
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        for (int indexX = 1; indexX <= str1Length; indexX++) {
            for (int indexY = 1; indexY <= str2Length; indexY++) {
                if (str1.charAt(indexX - 1) != str2.charAt(indexY - 1))
                    dp[indexX][indexY] = Math.max(dp[indexX - 1][indexY], dp[indexX][indexY - 1]);
                else
                    dp[indexX][indexY] = dp[indexX - 1][indexY - 1] + 1;
            }
        }

        return dp[str1Length][str2Length];
    }
}
