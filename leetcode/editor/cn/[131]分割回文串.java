//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1696 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    public List<List<String>> partition(String s) {
        return traverse(s, 0);
    }
    
    private boolean match(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    private List<List<String>> traverse(String s, int start) {
        if (start >= s.length()) {
            ArrayList<String> list = new ArrayList<>();
            return new ArrayList<>(Arrays.asList(list));
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start+1; i <= s.length(); i++) {
            String substr = s.substring(start, i);
            if (match(substr)) {
                List<List<String>> results = traverse(s, i);
                for (List<String> result : results) {
                    result.add(substr);
                    ans.add(result);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
