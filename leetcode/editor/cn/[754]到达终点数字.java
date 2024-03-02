//在一根无限长的数轴上，你站在0的位置。终点在target的位置。 
//
// 你可以做一些数量的移动 numMoves : 
//
// 
// 每次你可以选择向左或向右移动。 
// 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。 
// 
//
// 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 示例 2: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 
//
// 提示: 
//
// 
// -10⁹ <= target <= 10⁹ 
// target != 0 
// 
//
// Related Topics 数学 二分查找 👍 410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        
        int sum = 0;
        int i = 0;
        // 这里 i 会多加一次
//        for (i = 1; sum <= target; i++) {
//            sum += i;
//        }
        
        while(sum <= target) {
            sum += ++i;
        }
        
        if (sum == target || (sum - target) % 2 == 0) {
            return i;
        }
        
        sum += ++i;
        if ((sum - target) % 2 == 0) {
            return i;
        }
        
        return i+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
