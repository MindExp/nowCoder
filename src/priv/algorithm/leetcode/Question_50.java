package priv.algorithm.leetcode;

import java.util.Scanner;

/**
 * 50. Pow(x, n) 幂计算
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Question_50 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_50 question_50 = new Question_50();

        while (scanner.hasNextLine()) {
            double base = scanner.nextDouble();
            int exp = scanner.nextInt();
            double result = question_50.solution(base, exp);
            System.out.println(result);
        }
    }

    private boolean inValidData = false;

    /**
     * 快速幂运算：时间复杂度 O(logT), 其中 T 为 N 二进制位
     * 若 N 为偶数：A^(N) = A^(N / 2) * A^(N / 2)
     * 若 N 为奇数：A^(N) = A^(N / 2) * A^(N / 2) * A
     * @param base
     * @param exp
     * @return
     */
    public double solution(double base, int  exp) {
        if (base == 0 && exp == 0) {
            this.inValidData = true;
            return -1;
        }

        long rectifiedExp = exp;
        if (rectifiedExp < 0) {
            base = 1 / base;
            rectifiedExp = -rectifiedExp;
        }

        double result = 1;
        double currentBase = base;

        while (rectifiedExp != 0) {
            // 如果指数为奇数
            if ((rectifiedExp & 1) == 1)
                result *= currentBase;

            currentBase *= currentBase;
            rectifiedExp >>= 1;
        }
        return result;
    }
}
