package com.dachui.quickstart;

public class MergeTwoList {
    public ListNode MergeList(ListNode node1,ListNode node2){
        ListNode preHead =new ListNode(-1);
        //指针
        ListNode prev=preHead;
        while (node1!=null&&node2!=null){
            if(node1.val<=node2.val){
                //node1向后移
                prev.next=node1;
                node1=node1.next;
            }else {
                //node2向后移
                prev.next=node2;
                node2=node2.next;
            }
            //整体向后移
            prev=prev.next;
        }
        if(node1!=null){
            prev.next=node1;
        }else {
            prev.next=node2;
        }


        return preHead.next;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }