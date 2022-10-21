package com.LeeCode.Solution;

import org.junit.Test;
import org.w3c.dom.NodeList;

public class deleteDuplicates{
    @Test
    public void test(){
        ListNode head=new ListNode();
        head.add(1);
        head.add(1);

        deleteDuplicates(head).print();
    }
    public ListNode deleteDuplicates(ListNode head) {
        head=new ListNode(-1,head);
        ListNode itr=head;
        ListNode pre;
        while (itr!=null&&itr.next!=null){
            pre=itr;
            itr=itr.next;
            if(itr.next==null||itr.val!=itr.next.val) {//不是重复的
                continue;
            }
            //如果重复了，pre,到不重复的end之间删去
            ListNode end=itr;
            while (end!=null&&end.val==itr.val){
                end=end.next;
            }//用布尔值代替，只要end是不为空的，或者end的值相等就一直递推
            pre.next=end;
            itr=pre;
        }
        return head.next;
    }
}
