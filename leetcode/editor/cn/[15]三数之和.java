//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6719 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    // 先计算两数之和, index 对应的数不考虑
    // 先忽略 index 的存在
    public Pair twoSum(int[] nums, int sum, int index) {
        int l = 0;
        int r = nums.length;
        while(l < r) {
            if (nums[l] + nums[r] == sum) {
                return new Pair(nums[l], nums[r]);
            }
        }
        
    }
    
    public List<List<Integer>> threeSum(int[] nums) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
