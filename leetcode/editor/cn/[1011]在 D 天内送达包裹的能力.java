//传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。 
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最
//大运载重量。 
//
// 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。 
// 
//
// 示例 2： 
//
// 
//输入：weights = [3,2,2,4,1,4], days = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
// 
//
// 示例 3： 
//
// 
//输入：weights = [1,2,3,1,1], days = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days <= weights.length <= 5 * 10⁴ 
// 1 <= weights[i] <= 500 
// 
//
// Related Topics 数组 二分查找 👍 591 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int counter = 0;
        for (int i = 0; i < weights.length; ) {
            int j = i;
            int sum = 0;
            while(j < weights.length && sum+weights[j] <= capacity) {
                sum += weights[j];
                j++;
            }
            counter += 1;
            i = j;
        }
        
        return counter <= days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = Arrays.stream(weights).sum();
        
        while(l < r) {
         int m = (l + r) >> 1;
         if (canShip(weights, days, m)) {
             r = m;
         } else {
             l = m+1;
         }
        }
        
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
