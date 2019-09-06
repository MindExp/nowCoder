package priv.algorithm.leetcode;

import java.util.Scanner;

/**
 * 372. 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 */
public class Question_372 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question_372 question_372 = new Question_372();

        long result = question_372.superPow(3, new int[]{1,7,7,4,3,1,7,0,1,4,4,9,2,8,5,0,0,9,3,1,2,5,9,6,0,9,9,0,9,6,0,5,3,7,9,8,8,9,8,2,5,4,1,9,3,8,0,5,9,5,6,1,1,8,9,3,7,8,5,8,5,5,3,0,4,3,1,5,4,1,7,9,6,8,8,9,8,0,6,7,8,3,1,1,1,0,6,8,1,1,6,6,9,1,8,5,6,9,0,0,1,7,1,7,7,2,8,5,4,4,5,2,9,6,5,0,8,1,0,9,5,8,7,6,0,6,1,8,7,2,9,8,1,0,7,9,4,7,6,9,2,3,1,3,9,9,6,8,0,8,9,7,7,7,3,9,5,5,7,4,9,8,3,0,1,2,1,5,0,8,4,4,3,8,9,3,7,5,3,9,4,4,9,3,3,2,4,8,9,3,3,8,2,8,1,3,2,2,8,4,2,5,0,6,3,0,9,0,5,4,1,1,8,0,4,2,5,8,2,4,2,7,5,4,7,6,9,0,8,9,6,1,4,7,7,9,7,8,1,4,4,3,6,4,5,2,6,0,1,1,5,3,8,0,9,8,8,0,0,6,1,6,9,6,5,8,7,4,8,9,9,2,4,7,7,9,9,5,2,2,6,9,7,7,9,8,5,9,8,5,5,0,3,5,8,9,5,7,3,4,6,4,6,2,3,5,2,3,1,4,5,9,3,3,6,4,1,3,3,2,0,0,4,4,7,2,3,3,9,8,7,8,5,5,0,8,3,4,1,4,0,9,5,5,4,4,9,7,7,4,1,8,7,5,2,4,9,7,9,1,7,8,9,2,4,1,1,7,6,4,3,6,5,0,2,1,4,3,9,2,0,0,2,9,8,4,5,7,3,5,8,2,3,9,5,9,1,8,8,9,2,3,7,0,4,1,1,8,7,0,2,7,3,4,6,1,0,3,8,5,8,9,8,4,8,3,5,1,1,4,2,5,9,0,5,3,1,7,4,8,9,6,7,2,3,5,5,3,9,6,9,9,5,7,3,5,2,9,9,5,5,1,0,6,3,8,0,5,5,6,5,6,4,5,1,7,0,6,3,9,4,4,9,1,3,4,7,7,5,8,2,0,9,2,7,3,0,9,0,7}, 1337);
        System.out.println(result);
    }

    private boolean inValidData = false;

    /**
     * 快速幂计算 (a^b) mod c
     * (a + b) % p = (a % p + b % p) % p
     * (a - b) % p = (a % p - b % p) % p
     * (a * b) % p = (a % p * b % p) % p
     * a ^ b % p = ((a % p)^b) % p
     * @param base
     * @param expArray
     * @param mod
     * @return
     */
    private long superPow(int base, int[] expArray, int mod) {
        // 未通过所有测试用例，考虑 exp 超出 long 表示范围
        long exp = 0;
        for (int expElement : expArray) {
            exp = exp * 10 + expElement;
        }

        if (base == 0 && exp == 0) {
            this.inValidData = true;
            return 0;
        }

        long result = 1;
        long rectifiedExp = exp;
        if (exp < 0) {
            base = 1 / base;
            rectifiedExp = -rectifiedExp;
        }

        while (rectifiedExp != 0) {
            // rectifiedExp 为奇数
            if ((rectifiedExp & 1) == 1)
                result = result * base % mod;

            base = (base % mod) * (base % mod) % mod;
            rectifiedExp >>= 1;
        }
        return result;
    }
}
