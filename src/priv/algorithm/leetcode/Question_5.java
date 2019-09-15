package priv.algorithm.leetcode;

import java.util.Scanner;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Question_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_5 question_5 = new Question_5();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            String resultStr = question_5.longestPalindromeByCenter(str);
            System.out.println(resultStr);
        }
    }

    /**
     * 暴力解法：时间复杂度 O(N^3)
     * @param str
     * @return
     */
    private String longestPalindromeByViolence(String str) {
        String resultStr = "";
        int max = 0, strLength = str.length();

        for (int start = 0; start < strLength; start++) {
            for (int end = start; end < strLength; end++) {
                if (this.isPalindromic(str, start, end) && (end - start + 1) > max) {
                    resultStr = str.substring(start, end + 1);
                    max = end - start + 1;
                }
            }
        }
        return resultStr;
    }

    private boolean isPalindromic(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }

        return true;
    }

    /**
     * 掌握方案一：动态规划，扩散思想 dp[i][j] 代表 str.substring(i, j + 1) 是否为回文子串
     * dp[i][j] = (str.charAt(i) == str.charAt(j)) && (j - i < 2 ||dp[i + 1][j -1])
     * @param str
     * @return
     */
    private String longestPalindromeByDP(String str) {
        int strLength = str.length();
        boolean[][] dp = new boolean[strLength][strLength];
        String resultStr = "";

        for (int start = strLength - 1; start >= 0; start--) {
            for (int end = start; end < strLength; end++) {
                dp[start][end] = (str.charAt(start) == str.charAt(end)) &&
                        (end - start < 2 || dp[start + 1][end - 1]);

                if (dp[start][end] && (end - start + 1 > resultStr.length())) {
                    resultStr = str.substring(start, end + 1);
                }
            }
        }
        return resultStr;
    }

    /**
     * 掌握方法二：中心扩展思想，时间复杂度 O(N^2)，空间复杂度 O(1)
     * @param str
     * @return
     */
    private String longestPalindromeByCenter(String str) {
        int strLength = str.length();
        int start = 0, end = 0, maxlength = 0;
        String resultStr = "";

        for (int center = 0; center < strLength; center++) {
            // 两种中心扩展方案
            int expandOneLength = this.expandByCenter(str, center, center);
            int expandTwoLength = this.expandByCenter(str, center, center + 1);
            int expandLength = Math.max(expandOneLength, expandTwoLength);

            if (expandLength > maxlength) {
                maxlength = expandLength;
                start = center - (maxlength - 1) / 2;
                end = center + maxlength / 2;
                resultStr = str.substring(start, end + 1);
            }
        }
        return resultStr;
    }

    private int expandByCenter(String str, int start, int end) {
        int strLength = str.length();
        while (start >= 0 && end < strLength && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
