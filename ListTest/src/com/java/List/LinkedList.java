package com.java.List;
/*
判断是否为空，清空链表，返回0位置的游标，返回1位置的游标，移除一个元素，返回元素x的游标，返回元素x前一个游标，在游标处插入一个元素
 */
public class LinkedList {
    private ListNode header;
    public boolean isEmpty(){
        return header.next==null;
    }
    public void makeEmpty(){
        header.next=null;
    }
    public LinkedListItr zeroth(){
        return new LinkedListItr(header);
    }
    public LinkedListItr first(){
        return new LinkedListItr(header.next);
    }
    public LinkedListItr find(Object x){
        ListNode itr=header.next;
        while (itr!=null&&!itr.element.equals(x))
            itr =itr.next;
        return new LinkedListItr(itr);
    }
    public LinkedListItr findPrevious(Object x){
        ListNode itr=header.next;
        while (itr.next!=null&&!itr.next.element.equals(x))
            itr=itr.next;
        return  new LinkedListItr(itr);
    }
    public void remove(Object x){
        LinkedListItr p = findPrevious(x);
        if(p.current.next!=null)
            p.current.next=p.current.next.next;

    }
    public void insert(Object x,LinkedListItr p){
        if(p!=null&&p.current!=null)
            p.current.next=new ListNode(x,p.current.next);
    }
}
