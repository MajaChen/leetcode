//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
//
// Related Topics 树 数学 二叉树 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    public List<Integer> pathInZigZagTree(int label) {
        // 从 label 开始逐级寻找，直到根节点
        // 寻找过程：
        // 除2 - k；确定 k 所在的层级 - 进而确定的那个这一层级的最大值、最小值
        List<Integer> ints = new ArrayList<>();
        ints.add(label);
        while (label > 1) {
            int k = label / 2;
            int l = (int)(Math.log(k) / Math.log(2)) + 1;
            int max = (int) Math.pow(2, l) - 1;
            int min = (int) Math.pow(2, l-1);
            ints.add(max + min - k);
            label = max + min - k;
        }
        
        // 对 ints 倒置
        List<Integer> ans = new ArrayList<>();
        for (int i = ints.size() - 1; i >= 0; i--) {
            ans.add(ints.get(i));
        }
        
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
