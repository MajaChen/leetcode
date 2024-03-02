//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2598 👎 0


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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> nodes = new ArrayList<>();
        TreeNode fakeNode = new TreeNode();
        while(!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    nodes.add(node);
                } else {
                    nodes.add(fakeNode);
                }
            }
            if (!isSymmetric(nodes)) {
                return false;
            }
            nodes.clear();
        }
        return true;
    }
    
    private boolean isSymmetric(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 1) {
            return true;
        }
        
        int i = 0;
        int j = nodes.size() - 1;
        
        while (i <= j) {
            if (nodes.get(i++).val != nodes.get(j--).val) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
