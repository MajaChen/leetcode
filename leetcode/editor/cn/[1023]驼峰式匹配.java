//给你一个字符串数组 queries，和一个表示模式的字符串 pattern，请你返回一个布尔数组 answer 。只有在待查项 queries[i] 与模式
//串 pattern 匹配时， answer[i] 才为 true，否则为 false。 
//
// 如果可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。可以在任何位置插入每个字符，也可以不插入字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"],
// pattern = "FB"
//输出：[true,false,true,true,false]
//示例：
//"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer". 
//
// 示例 2： 
//
// 
//输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"],
// pattern = "FoBa"
//输出：[true,false,true,false,false]
//解释：
//"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
//"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
// 
//
// 示例 3： 
//
// 
//输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"],
// pattern = "FoBaT"
//输出：[false,true,false,false,false]
//解释： 
//"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pattern.length, queries.length <= 100 
// 1 <= queries[i].length <= 100 
// queries[i] 和 pattern 由英文字母组成 
// 
//
// Related Topics 字典树 数组 双指针 字符串 字符串匹配 👍 118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private boolean match(String query, String pattern) {
        int k = 0;
        for (int i = 0; i < query.length(); i++) {
            char x = query.charAt(i);
            char y = pattern.chatAt(k);
            if (k == pattern.length) {// pattern 已经到了顶点，query 还有大些字符则返回 false
                if (Character.isUpperCase(x)) {
                    return false
                }
            } else if (x == y) {
                ++k;
            } else if (Character.isUpperCase(x) ){
                return false;
            } else {// 字符不等，如果 query 是小写可以继续尝试
            
            }
        }
        
        return true;
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // 双指针 l r i k
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            if (match(query, pattern)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
