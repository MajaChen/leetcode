//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
//
// Related Topics 位运算 数组 回溯 👍 1178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for (int step = 1; step <= nums.length; step++) {
            List<List<Integer>> subAns = traverse(nums, 0, step);
            ans.addAll(subAns);
        }
        return ans;
    }

    private List<List<Integer>> traverse(int[] nums, int start, int count) {
        if (count == 0) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i+count <= nums.length; ) {
            List<List<Integer>> subRes = traverse(nums, start + 1, count - 1);
            for (List<Integer> l : subRes) {
                l.add(nums[i]);
            }
            res.addAll(subRes);

            for (i++; i < nums.length && nums[i] == nums[i-1]; i++){}
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
