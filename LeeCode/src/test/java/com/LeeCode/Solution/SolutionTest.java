package com.LeeCode.Solution;

import  org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void multiplyRandom() {
        while (true) {
            Random random = new Random();
            int x=random.nextInt(0,9999);
            int y=random.nextInt(0,9999);
            assertEquals("x :"+x+" y: "+y,String.valueOf(x*y),new Solution().multiply(String.valueOf(x),String.valueOf(y)));//加上消息的random调试
        }
    }

    @Test
    public void swapPairs() {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        solution.swapPairs(listNode);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
}