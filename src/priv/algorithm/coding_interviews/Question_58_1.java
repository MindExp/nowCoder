package priv.algorithm.coding_interviews;

/**
 * 58.1 翻转字符串
 * 例如：原始字符串“I am a student.”,则翻转后输出“student. a am I”
 */
public class Question58_1 {
    public static void main(String[] args) {
        String[] testInstances = {"I am a student.", "I. ", " am.", "Wonderful"};
        Question58_1 question58_1 = new Question58_1();

        for (String testInstance : testInstances) {
            String reversedStr = question58_1.reverseString(testInstance);
            System.out.println(reversedStr);
        }
    }

    /**
     * 时间复杂度 O(N), 空间复杂度 O(1)
     * @param str
     * @return
     */
    private String reverseString(String str) {
        if (str == null)
            return null;

        char[] charsArray = str.toCharArray();
        int start = 0, end = 0, strLength = str.length();

        this.reverse(charsArray, 0, strLength - 1);

        while (end != strLength) {
            if (charsArray[end] == ' ') {
                this.reverse(charsArray, start, end - 1);
                start = end + 1;
            } else if (end == strLength - 1)
                this.reverse(charsArray, start, end);
            end++;
        }

        return new String(charsArray);
    }

    private void reverse(char[] charsArray, int start, int end) {
        //输入异常处理
        if (charsArray == null || start < 0 || end < 0)
            return;

        while (start < end) {
            this.swap(charsArray, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] array, int i, int j) {
        // 输入异常处理
        if (array == null || i < 0 || j < 0)
            return;

        char ch = array[i];
        array[i] = array[j];
        array[j] = ch;
    }
}
