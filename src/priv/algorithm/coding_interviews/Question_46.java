package priv.algorithm.coding_interviews;

/**
 * 46. 把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Question_46 {
    public static void main(String[] args) {
        String[] testInstances = {"12258", "122058"};

        Question_46 question_46 = new Question_46();
        int result = 0;
        for (String testInstance : testInstances) {
            result = question_46.numberOfTranslations(testInstance);
            System.out.println(result);

            result = question_46.numOfDecodings(testInstance);
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

        pCount = str.charAt(0) == 0 ? 0 : 1;

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
