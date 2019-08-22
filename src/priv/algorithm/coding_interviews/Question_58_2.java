package priv.algorithm.coding_interviews;

/**
 * 58.2 左旋转字符串
 * 左旋转字符串，例如字符串“abcdefg”和数字2，则字符串左旋转两位结果为“cdefgab”。
 */
public class Question_58_2 {
    public static void main(String[] args) {
        String[] testInstances = {"abcdefg"};
        int[] reverseNumbers = {2, 3, 0};
        Question_58_2 question_58_2 = new Question_58_2();

        for (String testInstance : testInstances) {
            for (int reverseNumber : reverseNumbers) {
                String reversedStr = question_58_2.leftReverseString(testInstance, reverseNumber);
                System.out.println(reversedStr);
            }
        }
    }

    /**
     * 时间复杂度：O(N), 空间复杂度 O(1)， 此处空间复杂度指代原位置操作
     * @param str
     * @param number
     * @return
     */
    private String leftReverseString(String str, int number) {
        // 输入异常处理
        if (str == null || number < 0)
            return null;
        char[] charsArray = str.toCharArray();
        int start = 0, end = 0, strLength = str.length();

        this.reverse(charsArray, start, strLength - 1);

        end = strLength - number - 1;
        this.reverse(charsArray, start, end);

        start = end + 1;
        end = strLength - 1;
        this.reverse(charsArray, start, end);

        return new String(charsArray);
    }

    private void reverse(char[] charsArray, int start, int end) {
        if (charsArray == null || start < 0 || end < 0)
            return;

        while (start < end) {
            this.swap(charsArray, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] charsArray, int i, int j) {
        if (charsArray == null || i < 0 || j < 0)
            return;
        char ch = charsArray[i];
        charsArray[i] = charsArray[j];
        charsArray[j] = ch;
    }
}
