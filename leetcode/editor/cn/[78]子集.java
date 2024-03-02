//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2199 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traverse(0, nums, new HashSet<>());
        return ans;
    }

    private void traverse(int i, int[] nums, Set<Integer> current){
        if (i > nums.length) {
            return;
        }

        ans.add(new ArrayList<>(current));

        for (int j = i; j < nums.length; j++) {
            current.add(nums[j]);
            traverse(j+1, nums, current);
            current.remove(nums[j]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
