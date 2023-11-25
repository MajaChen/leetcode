package org.leetcode;

import org.leetcode.model.ListNode;

import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode fakeNode = new ListNode();
        ListNode p = list1;
        ListNode q = list2;
        ListNode r = fakeNode;
        while (p != null && q != null) {
            if (p.val >= q.val) {
                r.next = p;
                r = p;
                p = p.next;
            } else {
                r.next = q;
                r = q;
                q = q.next;
            }
        }

        if (p != null) {
            r.next = p;
            r = p;
        }

        if (q != null) {
            r.next = q;
            r = q;
        }

        return fakeNode.next;
    }
}
