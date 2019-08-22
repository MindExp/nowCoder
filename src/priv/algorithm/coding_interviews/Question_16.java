package priv.algorithm.coding_interviews;

/**
 * 16. 数值的整数次方
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 */
public class Question_16 {
    public static void main(String[] args) {

    }

    private double powerByNonRecursion(double base, int exponent) {
        double result = 1.0;
        int absultExponent = exponent < 0 ? -exponent : exponent;

        for (int i = 0; i < absultExponent; i++)
            result *= base;

        if (exponent < 0)
            result = 1 / result;

        return result;
    }

    private double powerByRecursion(double base, int exponent) {
        double result;

        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;

        boolean isNegativeOfExponent = false;

        if (exponent < 0) {
            isNegativeOfExponent = true;
            exponent *= -1;
        }

        result = this.powerByRecursion(base * base, exponent / 2);

        if (exponent % 2 == 1)
            result *= base;

        result = isNegativeOfExponent ? 1 / result : result;

        return result;
    }
}
