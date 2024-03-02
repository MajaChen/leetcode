//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1704 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ;  ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    class Pair {
        ListNode head;
        ListNode tail;

        public Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    private Pair reverse(ListNode head) {
        if (head.next == null) {
            return new Pair(head, head);
        }

        ListNode p = head.next;
        ListNode prev = head;
        prev.next = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new Pair(prev, head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;

        int c = -1;
        ListNode p = fakeHead;
        ListNode x = null;
        ListNode y = null;
        while (p != null) {
            /*
            * 这种写法可以从fakeHead开始，对比这种写法不能从fakeHead开始：
            * p = p.next;
            if (++c == n) {
                ...
            }
            * */
            if (++c == left - 1) {
                x = p;
            }
            if (c == right) {
                y = p;
            }
            p = p.next;
        }

        ListNode z = y.next;
        y.next = null;

        Pair pair = reverse(x.next);
        x.next = pair.head;
        pair.tail.next = z;

        return fakeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
