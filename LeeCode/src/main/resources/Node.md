#笔记
##找2个数组的中位数
###分类讨论奇数和偶数情况会很繁琐，所有最好想办法把奇数和偶数的情况整合起来，也就是应该做多遍历len/2+1次
用1个值，一个记录当前，一个记录上一次情况，一直记录到len/2次
##翻转k长度的链表
```java
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
        head=new ListNode(-1,head);
        ListNode p=head;
        ListNode tail;
        ListNode itr=head;
        int count=0;

        while (itr.next!=null){
            itr=itr.next;
            count++;//保证标号和自己想的一样就可以
            if(count%k==0){
                tail=itr;
                ListNode tempItr=p.next;
                ListNode tempItrNext=p.next.next;
                while (tempItr!=tail){
                    ListNode temp=tempItrNext.next;
                    tempItrNext.next=tempItr;
                    tempItr=tempItrNext;
                    tempItrNext=temp;
                }
                ListNode temp=p.next;
                p.next=tail;
                temp.next=tempItrNext;
                p=temp;
                itr=temp;
            }
        }
        return head.next;
    }
}
```
可以把翻转的部分分割起来简便计算。
##删除重复元素的方法
```java
class Solution {
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
```
```text
            while (end!=null&&end.val==itr.val){
                end=end.next;
            }//用布尔值代替，只要end是不为空的，或者end的值相等就一直递推
```
寻找到下一个不相等的或者null，用一个while循环条件写完即可