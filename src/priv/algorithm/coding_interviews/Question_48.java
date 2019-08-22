package priv.algorithm.coding_interviews;

import java.util.Arrays;

/**
 * 48. 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class Question_48 {
    public static void main(String[] args) {
        String[] testInstances = {"arabcacfr", ""};
        int result;

        Question_48 question_48 = new Question_48();

        for (String testinStance : testInstances) {
            result = question_48.longestSubStringWithoutDuplication(testinStance);
            System.out.println(result);
        }
    }

    /**
     * 动态规划：考虑第 i 个位置为最长子字串结束位置
     * @param str
     * @return
     */
    private int longestSubStringWithoutDuplication(String str) {
        if (str == null)
            return 0;

        int maxLength = 0, currentLength = 0, strLength = str.length();
        int[] preIndexArray = new int[26];

        Arrays.fill(preIndexArray, -1);

        for (int currentIndex = 0; currentIndex < strLength; currentIndex++) {
            int ch = str.charAt(currentIndex) - 'a';
            int preIndex = preIndexArray[ch];

            // currentLength 代表以 currentIndex - 1 结束的不含重复字符长度
            if (preIndex == -1 || currentIndex - preIndex > currentLength)
                currentLength++;
            else
                currentLength = currentIndex - preIndex;

            // 更新位置
            preIndexArray[ch] = currentIndex;

            if (currentLength > maxLength)
                maxLength = currentLength;
        }

        return maxLength;
    }
}
