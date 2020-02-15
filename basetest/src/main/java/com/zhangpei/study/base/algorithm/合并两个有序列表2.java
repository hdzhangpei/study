package com.zhangpei.study.base.algorithm;

public class 合并两个有序列表2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(9);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        ListNode l24 = new ListNode(7);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode newNode = mergeTwoLists(l1, l2);
        System.out.println(newNode);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
