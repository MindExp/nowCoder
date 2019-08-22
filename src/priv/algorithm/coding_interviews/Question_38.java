package priv.algorithm.coding_interviews;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 38. 字符串的排列
 * 输入一个字符串（可能存在重复字符），按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Question_38 {
    private ArrayList<String> resultPermutation = new ArrayList<>();

    public static void main(String[] args) {
        Question_38 question_38 = new Question_38();
        String str = "abc";
        // ArrayList<String> permutations = question_38.permutationOfStr(str);
        ArrayList<String> permutations = question_38.permutateOfSubstring(str);

        for (String result : permutations) {
            System.out.println(result);
        }
    }

    private ArrayList<String> permutationOfStr(String str) {
        if (str == null || str.length() == 0)
            return this.resultPermutation;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        this.permutate(chars, 0);
        return this.resultPermutation;
    }

    private void permutate(char[] chars, int index) {
        if (index == chars.length) {
            // System.out.println(chars);
            this.resultPermutation.add(new String(chars));
            return;
        }
        // 确定下标 i 处的只
        for (int i = index; i < chars.length; i++) {
            // 考虑重复元素，不交换
            if (i > index && chars[i] == chars[i - 1])
                continue;

            this.swap(chars, index, i);
            this.permutate(chars, index + 1);
            // 回溯为原始 chars
            this.swap(chars, index, i);
        }
    }

    private ArrayList<String> orderedSubString = new ArrayList<>();

    private ArrayList<String> permutateOfSubstring(String str) {
        if (str == null)
            return this.orderedSubString;

        StringBuffer stringBuffer = new StringBuffer();

        this.permutateOfSubstringAction(str.toCharArray(), 0, stringBuffer);

        return this.orderedSubString;
    }

    private void permutateOfSubstringAction(char[] chars, int index, StringBuffer stringBuffer) {
        if (index == chars.length) {
            orderedSubString.add(new String(stringBuffer));
            return;
        }

        this.permutateOfSubstringAction(chars, index + 1, stringBuffer.append(chars[index]));
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        this.permutateOfSubstringAction(chars, index + 1, stringBuffer);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void permutateByBackTracking(char[] chars, boolean[] visited, StringBuffer permutatedStr) {
        if (permutatedStr.length() == chars.length) {
            resultPermutation.add(permutatedStr.toString());
            return;
        }

        for (int index = 0; index < chars.length; index++) {
            if (visited[index])
                continue;
            // 处理重复字符
            if (index != 0 && chars[index] == chars[index - 1] && !visited[index - 1])
                continue;

            visited[index] = true;
            permutatedStr.append(chars[index]);
            this.permutateByBackTracking(chars, visited, permutatedStr);
            visited[index] = false;
            permutatedStr.deleteCharAt(permutatedStr.length() - 1);
        }
    }
}
