package com.info.leetcode;

import com.info.linkedlist.LinkedList;

/**
 * Created by M on 2018/8/18.
 */
public class Solution3 {

    ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

//        ListNode ret = removeElements(head.next, val);
//        if (head.val == val) {
//            return ret;
//        } else {
//            head.next = ret;
//            return head;
//        }

//        head.next = removeElements(head.next, val, 0);
//        return head.val == val ? head.next : head;

        ListNode res = removeElements(head.next, val, 0);
        System.out.print(depth);
        System.out.println("After remove " + val + " : " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++)
            sb.append("-- ");
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3().removeElements(head, 6, 0));
        System.out.println(res);
    }
}
