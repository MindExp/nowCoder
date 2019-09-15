package priv.algorithm.leetcode;

import java.util.Scanner;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Question_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_9 question_9 = new Question_9();
        while (scanner.hasNextLine()) {
            String strData = scanner.nextLine().trim();
            int data = Integer.parseInt(strData);

            boolean result = question_9.isPalindrome(data);
            System.out.println(result);
        }
    }

    /**
     * 时间复杂度：O(log(N))，空间复杂度：O(1)
     * @param data
     * @return
     */
    private boolean isPalindrome(int data) {
        if (data < 0 || (data != 0 && data % 10 == 0))
            return false;

        int reversedData = 0;
        while (reversedData < data) {
            reversedData = reversedData * 10 + data % 10;
            data /= 10;
        }

        return (reversedData == data) || (reversedData / 10 == data);
    }
}
