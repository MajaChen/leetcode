//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
//
// Related Topics 位运算 数学 👍 707 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b; // 得进位
            a = a ^ b; // 相加，可能有进位
            b = carry << 1; // 进位左移
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
