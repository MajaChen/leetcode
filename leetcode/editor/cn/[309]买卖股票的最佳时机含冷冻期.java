//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    * 状态转移方程
    * f(i,j):走到第i项，状态为j所能得到的最大利润
    * j:
    * 0：手上没有股票，f(i,0) = max(f(i+1,1) - prices[i]，f(i+1, 0))
    * 做出两个选择：买入这支股票 vs 不买股票
    * 1：手上有股票，f(i,1) = max(f(i+1,-1) + prices[i]， f(i+1, 1))
    * 做出两个选择：卖出这支股票 vs 不卖股票
    * -1：冷冻期
    * f(i,-1) = f(i+1, 0)
    *
    * */
    
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        
        dp[prices.length - 1][1] = prices[prices.length - 1];
        dp[prices.length - 1][0] = 0;
        dp[prices.length - 1][2] = 0;
        
        return traverse(prices, 0, 0);
    }
    
    private int traverse(int[] prices, int start, int state) {
        
        if (dp[start][state] >= 0) {
            return dp[start][state];
        }
        
        int maxProfit = 0;
        if (state == 0) {
            maxProfit = Math.max(traverse(prices, start+1, 1) - prices[start], traverse(prices, start+1, 0));
        } else if (state == 1) {
            maxProfit = Math.max(traverse(prices, start+1, 2) + prices[start], traverse(prices, start+1, 1));
        } else {
            maxProfit = traverse(prices, start+1, 0);
        }
        
        dp[start][state] = maxProfit;
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
