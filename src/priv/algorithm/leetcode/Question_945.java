package priv.algorithm.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 945. 给定整数数组A，每次 move 操作将会选择任意A[i]，并将其递增1，返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class Question_945 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_945 question_945 = new Question_945();

        while (scanner.hasNextLine()) {
            String str = scanner.next().trim();
            String[] strArray = str.split(",");
            int arrayLength = strArray.length;
            int[] array = new int[arrayLength];

            for (int index = 0; index < arrayLength; index++)
                array[index] = Integer.parseInt(strArray[index]);
            int counter = question_945.minIncrementForUnique(array);
            System.out.println(counter);
        }
    }

    private int minIncrementForUnique(int[] array) {
        int counter = 0;
        if (array == null || array.length == 0)
            return counter;

        int arrayLength = array.length;
        Arrays.sort(array);

        for (int index = 1; index < arrayLength; index++) {
            if (array[index - 1] >= array[index]) {
                // array[index] 元素增加次数
                counter += array[index - 1] - array[index] + 1;
                array[index] = array[index - 1] + 1;
            }
        }

        return counter;
    }
}
