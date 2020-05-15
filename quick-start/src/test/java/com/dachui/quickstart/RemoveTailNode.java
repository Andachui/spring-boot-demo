package com.dachui.quickstart;

public class RemoveTailNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //ListNode dummy = new ListNode(0);
        //dummy.next = head;

        ListNode pre = head;
        ListNode cur = head;
        // 率先走 n + 1 步，使 cur 指针最后指向要删除元素的前驱
        for (int i = 0; i < n +1; i++) {
            pre = pre.next;
        }
        // 此时同时往后移动指针，cur 停下来的位置就是要删除元素的前驱
        while (pre != null) {
            pre = pre.next;
            cur = cur.next;
        }
        // 将 cur 后面要删除的元素断链
        cur.next = cur.next.next;
        return head;
    }


}
