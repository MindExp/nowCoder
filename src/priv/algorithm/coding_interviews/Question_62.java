package priv.algorithm.coding_interviews;

/**
 * 62. 圆圈中最后剩下的数，约瑟夫环问题
 */
public class Question_62 {
    public static void main(String[] args) {
        int[] n = {1, 3, 5, 8, 100, 200};
        int[] m = {2, 5 ,2, 3, 5};
        int lastRemain;
        Question_62 question_62 = new Question_62();

        for (int i : n) {
            for (int j : m) {
                lastRemain = question_62.lastRemain(i, j);
                System.out.println(lastRemain);
            }
        }
    }

    /**
     * 约瑟夫环问题递归公式：
     * f(n, m) = 0,     n = 1;
     * f(n, m) = (f(n - 1, m) + m) % n;     n > 1;
     * @param n
     * @param m
     * @return
     */
    private int lastRemain(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int lastRemain = 0;

        for (int i = 2; i <= n; i++) {
            lastRemain = (lastRemain + m) % i;
        }

        return lastRemain;
    }
}
