package priv.algorithm.coding_interviews;

/**
 * 20. 表示数值的字符串
 */
public class Question_20 {
    public static void main(String[] args) {

    }
    /*
    []  ： 字符集合
    ()  ： 分组
    ?   ： 重复 0 ~ 1 次
    +   ： 重复 1 ~ n 次
    *   ： 重复 0 ~ n 次
    .   ： 任意字符
    \\. ： 转义后的 .
    \\d ： 数字
     */
    private boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)？");
    }
}
