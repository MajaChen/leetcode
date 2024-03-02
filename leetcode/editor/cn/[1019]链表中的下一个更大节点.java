//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 328 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Node {
    int val;
    int index;
    int greaterVal;
    
    Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // 栈空： 入栈
        // 不空，头节点比我小，出栈，直到遇到大于等我的或者栈空，最后再入栈
        // 不空，头节点大于等于我，入栈
        // 最后排出栈内元素
        List<Node> nodes = new ArrayList<>();
        ListNode p = head;
        Stack<Node> stack = new Stack<>();
        int counter = -1;
        while (p != null) {
            counter++;
            while (!stack.isEmpty() && stack.peek().val < p.val) {
                Node node = stack.pop();
                node.greaterVal = p.val;
                nodes.add(node);
            }
            stack.push(new Node(p.val, counter));
            
            p = p.next;
        }
        
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            node.greaterVal = 0;
            nodes.add(node);
        }
        
        int[] ans = new int[counter + 1];
        nodes.stream().forEach(x -> ans[x.index] = x.greaterVal);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
