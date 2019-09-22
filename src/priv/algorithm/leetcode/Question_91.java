package priv.algorithm.leetcode;

import java.util.Scanner;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class Question_91 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_91 question_91 = new Question_91();
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().trim();
            int result = question_91.numOfDecodings(str);
            System.out.println(result);
        }
    }

    /**
     * 动态规划求解：dp[i] = dp[i - 1] + dp[i - 2]，时间复杂度 O(n), 空间复杂度 O(n)
     * @param str
     * @return
     */
    private int numberOfTranslations(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int strLength = str.length();
        int pNumber, preNumber;
        // 自底向上求解，消除重复子问题
        int[] dp = new int[strLength + 1];

        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < strLength + 1; i++) {
            pNumber = Integer.valueOf(str.substring(i - 1, i));
            if (pNumber != 0)
                dp[i] += dp[i - 1];

            preNumber = Integer.valueOf(str.substring(i - 2, i));
            if (preNumber >= 10 && preNumber <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[strLength];
    }

    /**
     * 动态规划求解：dp[i] = dp[i - 1] + dp[i - 2]，时间复杂度 O(n), 空间复杂度 O(1)
     * @param str
     * @return
     */
    private int numOfDecodings(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int strLength = str.length();
        int preCount = 1, pCount, tempCount;
        int pNumber, preNumber;

        pCount = str.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < strLength + 1; i++) {
            tempCount = pCount;
            pNumber = Integer.valueOf(str.substring(i - 1, i));
            if (pNumber == 0)
                pCount = 0;

            preNumber = Integer.valueOf(str.substring(i - 2, i));
            if (preNumber >= 10 && preNumber <= 26)
                pCount += preCount;
            preCount = tempCount;
        }

        return pCount;
    }
}
