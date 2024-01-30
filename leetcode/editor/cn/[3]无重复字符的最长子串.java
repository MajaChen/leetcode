//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9823 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLen = -1;
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            r = i;
            if (mapping.containsKey(s.charAt(i))) {
                int j = mapping.get(s.charAt(i));
                for (int m = l; m <= j; m++) {
                    mapping.remove(s.charAt(m));
                }
                l = j+1;
            }
            mapping.put(s.charAt(i), i);
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
            }
        }
        
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
