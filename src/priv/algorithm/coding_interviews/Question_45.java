package priv.algorithm.coding_interviews;

import java.util.Arrays;

/**
 * 45. 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 *
 */
public class Question_45 {
    public static void main(String[] args) {
        int[][] testInstances = {{3, 32, 321}, {34, 5633, 56520, 445}};
        String result;

        Question_45 question_45 = new Question_45();

        for (int[] testInstance : testInstances) {
            result = question_45.printMinNumber(testInstance);
            System.out.println(result);
        }
    }

    private String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        int numLength = numbers.length;
        String[] strNumbers = new String[numLength];
        StringBuffer strResult = new StringBuffer();

        for (int index = 0; index < numLength; index++)
            strNumbers[index] = numbers[index] + "";

        Arrays.sort(strNumbers, (s1, s2)->(s1 + s2).compareTo(s2 + s1));

        for (String str : strNumbers)
            strResult.append(str);

        return strResult.toString();
    }
}
