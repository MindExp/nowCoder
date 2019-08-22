package priv.algorithm.coding_interviews;

import java.util.Arrays;

/**
 * 61. 扑克牌顺子
 * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 */
public class Question_61 {
    public static void main(String[] args) {

    }

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5)
            return false;

        int zeroCounter = 0;
        for (int number : numbers) {
            if (number == 0)
                zeroCounter++;
        }

        Arrays.sort(numbers);

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != 0) {
                if (index > 0 && numbers[index - 1] != 0 && numbers[index] != numbers[index - 1] + 1) {
                    if (numbers[index] == numbers[index - 1])
                        return false;
                    zeroCounter -= numbers[index] - numbers[index - 1] - 1;
                    if (zeroCounter < 0)
                        return false;
                }
            }
        }
        return zeroCounter >= 0;
    }
}
