package com.java.List;


/*
 游标类
 访问下一个元素，看是遍历到了末尾指向的NULL，求出当前位置的值
 */
public class LinkedListItr {
    ListNode current;
    public boolean isPastEnd(){
        if(current==null)
            return true;
        else
            return false;
    }
    public void advance(){
        if(!isPastEnd())
            current=current.next;
    }
    public Object retrieve() {
        return isPastEnd()?null:current.element;
    }
    LinkedListItr(ListNode thrCurrent){
        current=thrCurrent;
    }
}
