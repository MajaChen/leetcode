//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int maximalProduct = 1;// 表示紧贴着i的最大乘积
        int minimulProdut = 1;// 表示紧贴着i的最小乘积
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = nums[i] * maximalProduct;
            int z = nums[i] * minimulProdut;
            
            // 三者中找最大值
            int max = x;
            if (y > max) {
                max = y;
            }
            if (z > max) {
                max = z;
            }
            
            if (max > ans) {
                ans = max;
            }
            
            // 三者中找最小值
            int min = x;
            if (y < min) {
                min = y;
            }
            if (z < min) {
                min = z;
            }
            
            maximalProduct = max;
            minimulProdut = min;
            // 这样的出来的最大值和最小值是不连续的
//            if (max > maximalProduct) {
//                maximalProduct = max;
//            }
//
//            if (min < minimulProdut) {
//                minimulProdut = min;
//            }
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
