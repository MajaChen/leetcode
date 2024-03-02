//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 枚举 👍 160 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private static class Pair {
        String x;
        String y;
        
        public Pair(String i, String j) {
            this.x = i;
            this.y = j;
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    
    public List<String> subset(String s) {
        int n = s.length();
        if (n == 1) {
            return Arrays.asList(s);
        }
        
        List<String> ans = new ArrayList<>();
        
        // 在 i 指示的字符后面插入小数点
        // (0.0 1.0 1.20) (01.1)
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(n - 1) == '0') {
                continue;
            }
            if (s.charAt(0) == '0' && i != 0) {
                continue;
            }
            ans.add(s.substring(0, i+1) + "." + s.substring(i+1, n));
        }
        
        // 不加小数点的情况
        // (00, 01, 0001)
        if (s.charAt(0) != '0') {
            ans.add(s);
        }
        
        return ans;
    }
    
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        s = s.substring(1, s.length()-1);
        // 在 i 指示的字符后面插入空格进行分割
        for (int i = 0; i < s.length() - 1; i++) {
            List<String> left = subset(s.substring(0, i + 1));
            List<String> right = subset(s.substring(i + 1, s.length()));
            if (left.size() > 0 && right.size() > 0) {
                for (String l : left) {
                    for (String r : right) {
                        Pair pair = new Pair(l, r);
                        ans.add(pair.toString());
                    }
                }
            }
        }
        
        return ans;
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)
