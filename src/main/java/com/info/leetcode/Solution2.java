package com.info.leetcode;

/**
 * Created by M on 2018/8/18.
 */
public class Solution2 {
    ListNode removeElements(ListNode head, int val) {

        ListNode dumyHead = new ListNode(-1);
        dumyHead.next = head;

        ListNode pre = dumyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else
                pre = pre.next;
        }
        return dumyHead.next;
    }
}
