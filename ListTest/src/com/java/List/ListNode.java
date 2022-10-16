package com.java.List;

public class ListNode {
    Object element;
    ListNode next;
    ListNode(Object theElement){
        this.element=theElement;
    }
    ListNode(Object theElement,ListNode theNext){
        this(theElement);//可以构造函数可以调用，自己的构造函数，使用this(typename theElement)
        next=theNext;
    }
}
