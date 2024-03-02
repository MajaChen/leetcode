//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 488 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        /*
         * 6 7为例
         * 0110
         * 0111
         * i首次得到的值是4
         * 但是如果再添个8：
         * 1000
         * 9就更不用说了：
         * 1001
         *
         * */
        int res = 0;
        while (left > 0) {
            int i = (int) Math.pow(2, Math.floor(Math.log(left) / Math.log(2)));
            if (right >= 2 * i) {
                return res;
            } else {
                res += i;
            }
            left -= i;
            right -= i;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
