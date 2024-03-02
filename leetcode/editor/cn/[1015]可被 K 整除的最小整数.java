//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。 
//
// 返回 n 的长度。如果不存在这样的 n ，就返回-1。 
//
// 注意： n 可能不符合 64 位带符号整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 1
//输出：1
//解释：最小的答案是 n = 1，其长度为 1。 
//
// 示例 2： 
//
// 
//输入：k = 2
//输出：-1
//解释：不存在可被 2 整除的正整数 n 。 
//
// 示例 3： 
//
// 
//输入：k = 3
//输出：3
//解释：最小的答案是 n = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 👍 167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRepunitDivByK(int k) {
        int m = 1;
        Set<Integer> mods = new HashSet<>();
        while(true) {
            if (m % k == 0) {
                return m;
            }
            
            int i = m % k;
            if (mods.contains(i)) {
                break;
            }
            
            mods.add(i);
            m += m * 10;
        }
        
        return -1;
    }
    
    // s 保证有效，例如 -344.75
    public int stringToFloat(String s) {
        boolean isNegtive = false;
        boolean beforePoint = true;
        float sum = 0f;
        float sumPoint = 0f;
        int count = 10;
        for (int i = 0; i < s.length; i++) {
            if (s.charAt(i) == '-') {
                isNegtive = true;
            } else if (s.charAt(i) == '.') {
                beforePoint = false;
            } else if (beforePoint) {
                int i = Character.getNumericValue(s.charAt(i));
                sum = sum * 10 + i;
            } else {
                int i = Character.getNumericValue(s.charAt(i));
                sumPoint += i / count;
                count *= 10;
            }
        }
        
        float ans = sum + sumPoint;
        if (isNegtive) {
            ans = 0 - ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
