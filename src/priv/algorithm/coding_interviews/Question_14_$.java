package priv.algorithm.coding_interviews;

/**
 * 14. 剪绳子
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 *
 */
public class Question_14_$ {
    public static void main(String[] args) {
        Question_14_$ question_14$ = new Question_14_$();
        int maxBreakValue;
        maxBreakValue = question_14$.intergerBreak(10);
        System.out.println(maxBreakValue);

    }

    private int intergerBreak(int n) {
        int result = -1;
        if (n == 1)
            return 1;
        if (n == 2 || n == 3)
            return n - 1;

        int temp;
        for (int firstCut = 1; firstCut <= n / 2; firstCut++) {
            temp = this.intergerBreak(firstCut) * this.intergerBreak(n - firstCut);
            if (result < temp)
                result = temp;
        }
        return result;
    }
}
