//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,3,4]
//输出: 4 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int k = i+2;
                while(nums[k] == 0 || nums[i] + nums[j] <= nums[k]) {
                    k++;
                }
                ans += k - j + 1;
            }
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
