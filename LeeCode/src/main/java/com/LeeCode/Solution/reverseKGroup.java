package com.LeeCode.Solution;

import org.junit.Test;
import org.w3c.dom.NodeList;

import java.awt.*;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class reverseKGroup {
    @Test

    public void test(){
        ListNode head=new ListNode();
        head.add(5);
        head.add(4);
        head.add(3);
        head.add(2);
        head.add(1);
        reverseKGroup(head.next,2).print();
    }
    //看看复杂的问题可不可以分割成函数来计算
    public ListNode reverseKGroup(ListNode head, int k) {
        head=new ListNode(-1,head);//头部分插入一个链表
        ListNode itr=head;
        int listNum=0;
        ListNode pre=head;//前
        while (itr.next!=null){
            itr=itr.next;
            listNum++;
            if(listNum%k==0){
                ListNode next=itr.next;
                itr.next=null;
                ListNode p=pre.next;
                pre.next=reverse(p);//变成尾结点， 返回头结点
                p.next=next;//尾节点和next连接
                pre=p;//为下面的循环做准备
                itr=p;
            }
        }
        return head.next;

    }
    //翻转链表，头结点变成尾节点，返回头结点。
    public  ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode itr=head;
        ListNode itrNext=head.next;
        while (itrNext!=null){
            ListNode t=itrNext.next;
            itrNext.next=itr;
            itr=itrNext;
            itrNext=t;
        }
        return itr;
    }
}
