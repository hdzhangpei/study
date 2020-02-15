package com.zhangpei.study.base.algorithm;

/**
 * 比较复杂,理解费劲
 */
public class 合并两个有序链表 {
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


        ListNode newListNode = new ListNode(0);
        ListNode current = newListNode;

        while(l1 !=null && l2 != null) {
            if(l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else{
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        if(l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        System.out.println(newListNode.next);
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
