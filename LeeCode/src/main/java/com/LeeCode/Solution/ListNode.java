package com.LeeCode.Solution;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      public void add(int val){
          ListNode t=next;
          next=new ListNode(val,t);
      }
      public void  print(){
          if(next==null)
              System.out.println("null");
          else {
              ListNode t=next;
              while (t!=null)
              {
                  System.out.print(t.val+" ");
                  t=t.next;
              }
              System.out.println("");
          }

      }
}
