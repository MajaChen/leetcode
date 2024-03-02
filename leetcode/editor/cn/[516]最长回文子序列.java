//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int maxLen = 1;
        int n = s.length();
        int dp = new int[n-1][n-1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n && i+j <= n ; j++) {
                int l = i;
                int r = i+j-1;
                if (l == r) {
                    dp[l][r] = 1;
                } else if (r - l == 1) {
                    dp[l][r] = s.charAt(l) == s.charAt(r) ? 2 : 1;
                } else {
                    if (s.charAt(l) == s.charAt(r)) {
                        dp[l][r] = dp[i+1][j-1] + 2;
                    } else {
                        dp[l][r] = Math.max(dp[l+1][r], dp[l][r-1]);
                    }
                }
                if (dp[l][r] > maxLen) {
                    maxLen = dp[l][r];
                }
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
