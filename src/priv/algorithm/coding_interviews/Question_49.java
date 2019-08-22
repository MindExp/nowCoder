package priv.algorithm.coding_interviews;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */
public class Question_49 {
    public static void main(String[] args) {
        int[] testInstances = {1, 10, 100, 200};
        Question_49 question_49 = new Question_49();
        int result;

        for (int testInstance : testInstances) {
            result = question_49.getKthUglyNumber(testInstance);
            System.out.println(result);
            result = question_49.getKthUglyNumberByViolence(testInstance);
            System.out.println(result);
        }
    }

    private int getKthUglyNumber(int k) {
        if (k <= 0)
            return -1;

        int[] dp = new int[k];
        int pos2 = 0, pos3 = 0, pos5 = 0, nextPos = 1;
        int min, result;
        dp[0] = 1;

        while (nextPos < k) {
            min = Math.min(dp[pos2] * 2 , Math.min(dp[pos3] * 3, dp[pos5] * 5));
            dp[nextPos] = min;

            while (dp[pos2] * 2 <= dp[nextPos])
                pos2++;
            while (dp[pos3] * 3 <= dp[nextPos])
                pos3++;
            while (dp[pos5] * 5 <= dp[nextPos])
                pos5++;

            nextPos++;
        }
        result = dp[k - 1];

        return result;
    }

    private int getKthUglyNumberByViolence(int k) {
        if (k <= 0)
            return 0;

        int uglyNumber = 0, number = 0;

        while (uglyNumber < k) {
            number++;

            if (this.isUglyNumber(number))
                uglyNumber++;
        }

        return number;
    }

    private boolean isUglyNumber(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;

        return number == 1;
    }
}
