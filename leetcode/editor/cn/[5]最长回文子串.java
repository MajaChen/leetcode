//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6956 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = -1;
        int m = 0;
        int n = 0;
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i + l -1 < s.length(); i++) {
                int x = i;
                int y = i + l -1;
                if (getDpVal(x, y, s, dp)) {
                    if (y - x + 1 > max) {
                        max = y - x + 1;
                        m = x;
                        n = y;
                    }
                }
            }
        }
        return s.substring(m, n+1);
    }
    
    private boolean getDpVal(int i, int j, String s, boolean[][] dp) {
        if (i == j) {
            dp[i][j] = true;
        } else if (j - i == 1) {
            dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
            dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
        }
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
