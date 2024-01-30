//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1508 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode nullNode = null;
    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        return traverse(nums, 0, n-1);
    }
    
    private List<TreeNode> traverse(int[] nums, int l, int r) {
        if (l > r) {
            return new ArrayList<>(Arrays.asList(nullNode));
        }
        if(l == r) {
            return new ArrayList<>(Arrays.asList(new TreeNode(nums[l])));
        }
        
        List<TreeNode> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftChildern = traverse(nums, l, i - 1);
            List<TreeNode> rightChildern = traverse(nums, i+1, r);
            for (TreeNode ln : leftChildern) {
                for (TreeNode rn : rightChildern) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = ln;
                    root.right = rn;
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
