package priv.algorithm.DP;

import java.util.Scanner;

/**
 * 77_2. 最长公共子串
 * 给定两个字符串，返回长公共子串长度
 */
public class Question_77_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_77_2 question_77_2 = new Question_77_2();
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine().trim();
            String str2 = scanner.nextLine().trim();
            int result = question_77_2.longestCommonSubStringLengthByDP(str1, str2);
            System.out.println(result);
        }
    }

    private boolean inValidData = false;

    /**
     * 常规方案
     * @param str1
     * @param str2
     * @return
     */
    private int longestCommonSubStringLength(String str1, String str2) {
        if (str1 == null || str2 == null) {
            this.inValidData = true;
            return 0;
        }

        int str1Length = str1.length(), str2Length = str2.length(), result = 0;

        for (int indexX = 0; indexX < str1Length; indexX++) {
            for (int indexY = 0; indexY < str2Length; indexY++) {
                int indexCmp = 0;
                while (indexX + indexCmp < str1Length && indexY + indexCmp < str2Length
                        && str1.charAt(indexX + indexCmp) == str2.charAt(indexY + indexCmp)) {
                    indexCmp++;
                }
                result = Math.max(result, indexCmp);
            }
        }

        return result;
    }

    /**
     * 动态规划求解
     * dp[i][j]：代表以 str1.charAt(i) 与 str2.charAt(j) 为结束字符的子串长度
     * @param str1
     * @param str2
     * @return
     */
    private int longestCommonSubStringLengthByDP(String str1, String str2) {
        if (str1 == null || str2 == null) {
            this.inValidData = true;
            return 0;
        }

        int str1Length = str1.length(), str2Length = str2.length(), result = 0;
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        for (int indexX = 1; indexX <= str1Length; indexX++) {
            for (int indexY = 1; indexY <= str2Length; indexY++) {
                if (str1.charAt(indexX - 1) != str2.charAt(indexY - 1))
                    dp[indexX][indexY] = 0;
                else
                    dp[indexX][indexY] = dp[indexX - 1][indexY - 1] + 1;

                result = Math.max(result, dp[indexX][indexY]);
            }
        }

        return result;
    }
}
