package priv.algorithm.coding_interviews;

/**
 * 67. 把字符串转换成整数
 */
public class Question_67 {
    public static void main(String[] args) {
        String[] testInstances = {"123", "0123", "1230", "1203", "asd232", "+123", "-123", "+", "-"};
        Question_67 question_67 = new Question_67();

        for (String testInstance : testInstances) {
            int result = question_67.StrToInt(testInstance);
            System.out.println(result);
        }
    }

    private boolean invalidData = false;

    private int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            this.invalidData = true;
            return 0;
        }

        int result = 0, strLength = str.length();

        for (int index = 0; index < strLength; index++) {
            char ch = str.charAt(index);
            if (ch == '+' || ch == '-')
                continue;

            if (ch >= '0' && ch <= '9') {
                int check = result;
                result = result * 10 + (ch - '0');
                // 越界检查
                if ((result - (ch - '0')) / 10 != check)
                    return 0;
            } else
                return 0;
        }
        result = str.charAt(0) == '-' ? -result : result;
        return result;
    }
}
