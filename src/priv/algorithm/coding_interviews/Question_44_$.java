package priv.algorithm.coding_interviews;

/**
 * 44. 数字序列中的某一位数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 */
public class Question_44_$ {
    public static void main(String[] args) {
        Question_44_$ question_44_$ = new Question_44_$();
        int[] testInstances = {1001, 89, 45673, 5, 13, 19};
        int result;

        for (int testInstance : testInstances) {
            result = question_44_$.findNumber(testInstance);
            System.out.println(result);
        }
    }

    // 存在位置 bug 待修复
    private int findNumber(int target) {
        int preCounter, counter = 0, max = Integer.MAX_VALUE;
        int result = -1;

        for (int bit = 1; bit <= max; bit++) {
            preCounter = counter;
            counter += this.bitCount(bit);

            if (counter > target) {
                int num = (target - preCounter) / bit;
                int i = (target - preCounter) % bit;
                int start = (int)Math.pow(10, bit - 1);

                result = this.getBit(start + num, i);

                return result;
            }
        }

        return result;
    }

    private int getBit(int number, int bit) {
        String str = String.valueOf(number);
        char targetChar = str.toCharArray()[bit - 1];

        return Integer.valueOf(targetChar + "");
    }

    private int bitCount(int n) {
        if (n <= 0)
            return 0;

        int result = 9 * (int)Math.pow(10, n - 1) * n;

        return result;
    }
}
