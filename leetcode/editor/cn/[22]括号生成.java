//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        traverse(n, 0, 0, "");
        return ans;
    }
    
    private void traverse(int n, int l, int r, String part) {
        if (l + r == 2 * n) {
            ans.add(part);
            return;
        }
        if (l + 1 <= n && l + 1 >= r) {// 补充左括号
            traverse(n, l + 1, r, part + "(");
        }
        if (r + 1 <= n && l >= r + 1) {// 补充右括号
            traverse(n, l, r + 1, part + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
