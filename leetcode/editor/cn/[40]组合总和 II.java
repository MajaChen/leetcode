//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1490 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traverse(candidates, new ArrayList<Integer>(), target, 0);
        return ans;
    }

    public void traverse(int[] candidates, List<Integer> selectedCandidates, int target, int index) {
        for (int i = index; i < candidates.length; ) {
            if (candidates[i] > target) {
                return;
            }
            if (candidates[i] == target) {
                List<Integer> newCandidates = new ArrayList<>(selectedCandidates);
                newCandidates.add(candidates[i]);
                ans.add(newCandidates);
                return;
            }
            selectedCandidates.add(candidates[i]);
            traverse(candidates, selectedCandidates, target - candidates[i], i+1);
            selectedCandidates.remove(selectedCandidates.size()-1);
            for (i++; i < candidates.length && candidates[i] == candidates[i-1]; i++) {}
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
