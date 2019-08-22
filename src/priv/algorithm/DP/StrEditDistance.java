package priv.algorithm.DP;

import java.util.Scanner;

/**链接：https://www.nowcoder.com/questionTerminal/3959837097c7413a961a135d7104c314
 * 字符串之间的距离，编辑距离，将strA编辑成strB所需的最小代价
 * 编辑操作包括插入一个字符、删除一个字符、替换一个字符
 * 分别对应的代价是ic、dc、rc，insert cost、delete cost、replace cost
 */
public class StrEditDistance {
    public static void main(String[] args) {
        int insertCost = 3, deleteCost = 2, replaceCost = 1;
        StrEditDistance strEditDistance = new StrEditDistance();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(strEditDistance.strEditDistance(str1, str2, insertCost, deleteCost, replaceCost));
        }
    }

    private int strEditDistance(String str1, String str2, int insertCost, int deleteCost, int replaceCost) {
        int str1Length = str1.length(), str2Length = str2.length();
        // dp[i][j] 表示将字符串 0~i 编辑为 0~j 的代价
        int[][] dp = new int[str1Length + 1][str2Length + 1];

        // str1 为空
        for (int index = 1; index <= str2Length; index++)
            dp[0][index] = dp[0][index - 1] + insertCost;

        // str2 为空
        for (int index = 1; index <= str1Length; index++)
            dp[index][0] = dp[index - 1][0] + deleteCost;

        for (int i = 1; i <= str1Length; i++) {
            for (int j = 1; j <= str2Length; j++) {
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    // 替换代价：将 str1.charAt(i) 替换为 str2.charAt(j)
                    int rc = dp[i - 1][j - 1] + replaceCost;
                    // 删除代价：将 str1.charAt(i) 删除
                    int dc = dp[i - 1][j] +deleteCost;
                    // 插入代价：将 str2.charAt(j) 插入
                    int ic = dp[i][j - 1] + insertCost;
                    dp[i][j] = Math.min(rc, Math.min(dc, ic));
                } else
                    // 相等不需要编辑
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }

        return dp[str1Length][str2Length];
    }
}
