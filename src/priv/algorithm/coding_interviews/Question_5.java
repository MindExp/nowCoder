package priv.algorithm.coding_interviews;

/**
 * 5. 替换空格
 * 将一个字符串中的空格替换成 "%20"。
 * 测试用例：(AS D  SD, AS%20D%20%20SD)，(  , %20%20)
 */
public class Question_5 {
    public static void main(String[] args) {
        StringBuffer[] stringBuffers = {new StringBuffer("AS D  SD"), new StringBuffer("  ")};

        Question_5 question_5 = new Question_5();

        for (StringBuffer stringBuffer1: stringBuffers)
            System.out.println(question_5.replaceSpace(stringBuffer1));

    }

    /**
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int oldStrLength = str.length();
        for (int i = 0; i < oldStrLength; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int newStrLength = str.length();
        oldStrLength = --oldStrLength;
        newStrLength = --newStrLength;
        while (oldStrLength >= 0 && oldStrLength != newStrLength){
            if (str.charAt(oldStrLength) == ' '){
                str.setCharAt(newStrLength--, '0');
                str.setCharAt(newStrLength--, '2');
                str.setCharAt(newStrLength--, '%');
                oldStrLength--;
            }else
                str.setCharAt(newStrLength--, str.charAt(oldStrLength--));
        }

        return str.toString();
    }
}
