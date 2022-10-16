package com.LeeCode.Solution;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public String multiply(String num1, String num2) {
        //排除0
        if(num1.equals("0")|| num2.equals("0"))
            return "0";
        //数组初始化
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        int[] ansIntArray = new int[num1.length() + num2.length()-1];//注意最低的情况是L1+L2-1
        Arrays.setAll(ansIntArray, x -> 0);
        //没有去倒叙，因为不需要。
        for (int yIndex = 0; yIndex < num2.length(); yIndex++) {
            for (int xIndex = 0; xIndex < num1.length(); xIndex++) {
                ansIntArray[yIndex + xIndex] += (int) (num1CharArray[xIndex] - '0') * (int) (num2CharArray[yIndex] - '0');
            }
        }
        StringBuffer ansBuffer = new StringBuffer();
        //进位和保留，注意第一位不处理，要倒过来处理
        for (int i = ansIntArray.length - 1; i > 0; i--) {
            ansIntArray[i - 1] += ansIntArray[i] / 10;
            ansIntArray[i] = ansIntArray[i] % 10;
            ansBuffer.append(ansIntArray[i]);
        }
        //处理0和最后一位
        ansBuffer.append(ansIntArray[0] % 10);
        if(ansIntArray[0]>=10)
            ansBuffer.append(ansIntArray[0] / 10);
        return ansBuffer.reverse().toString();
    }
    /*
    * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
    //List name = new ArrayList<>()
    //没考虑到如果3个数中可能互相相同的情况
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansLists = new ArrayList<>();
        ArrayList<Integer> simplyNums=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i-1]!=nums[i]){//i==0时候加进去，不需要考虑后者，i！=0时候根据后者加进去
                simplyNums.add(Integer.valueOf(nums[i]));
            }

        }
        for(int begin=0;begin<simplyNums.size()-2;begin++){
            int mid=begin+1;
            int end=simplyNums.size()-1;
            while (mid<end&&end<=simplyNums.size()-1&&mid>=begin+1){
                int tempSum=simplyNums.get(begin).intValue()+ simplyNums.get(mid).intValue()+simplyNums.get(end).intValue();
                if(tempSum==0) {
                    //ArrayList<Type> obj = new ArrayList<Type>(Arrays.asList(Object o1, Object o2, Object o3, ....so on));
                    //上面是一种初始化的方式
                    //也可以使用匿名内部类
                    ansLists.add(new ArrayList<>(Arrays.asList(simplyNums.get(begin),simplyNums.get(mid),simplyNums.get(end))));
                    mid++;
                    end--;
                }
                else if(tempSum<0){
                    mid++;
                }
                else if(tempSum>0){
                    end--;
                }

            }
        }
        return ansLists;
    }
    //回文数
    public boolean isPalindrome(int x) {
            String abc = String.valueOf(x);
            StringBuffer cbaBuilder=new StringBuffer();
            for(int i=abc.length()-1;i>=0;i--){
                cbaBuilder.append(abc.charAt(i));
            }
            return abc.equals(cbaBuilder.toString());

    }
    //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    //
    //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //返回容器可以储存的最大水量。
    //
    //说明：你不能倾斜容器。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/container-with-most-water
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxArea(int[] height) {
    //双指针，开始指针一左一右，根据实际情况来缩小范围，判断左指针和有指针的情况,只要一定方式不会漏掉目标就可以,可以减少2层for循环的不必要的讨论
        /*
        * 若暴力枚举，水槽两板围成面积 S(i, j)S(i,j) 的状态总数为 C(n, 2)C(n,2) 。

假设状态 S(i, j)S(i,j) 下 h[i] < h[j]h[i]<h[j] ，在向内移动短板至 S(i + 1, j)S(i+1,j) ，则相当于消去了 {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}S(i,j−1),S(i,j−2),...,S(i,i+1) 状态集合。而所有消去状态的面积一定都小于当前面积（即 < S(i, j)<S(i,j)），因为这些状态：

短板高度：相比 S(i, j)S(i,j) 相同或更短（即 \leq h[i]≤h[i] ）；
底边宽度：相比 S(i, j)S(i,j) 更短；

作者：jyd
链接：https://leetcode.cn/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
        int left=0;int right=height.length-1;
        int maxAreaAns=-1;
        while (left<right){
            int nowArea=Math.min(height[left],height[right])*right-left;
            maxAreaAns=Math.max(nowArea,maxAreaAns);
            if(height[left]<height[right])
                left++;
            else right--;
        }
        return maxAreaAns;
    }
    /*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。*/

    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        head = new ListNode(-1, head);
        ListNode itr = head.next;
        ListNode preItr = null;
        ListNode prepreItr=head;
        int listNum = 0;
        while (itr != null) {
            if (listNum % 2 == 0)
            {   preItr = itr;
                itr=itr.next;
            }
            else {
                prepreItr.next=itr;
                prepreItr=preItr;
                ListNode p=itr.next;
                itr.next=preItr;
                preItr.next=p;
                itr=p;
            }
            listNum++;
        }
        return head.next;
    }
}
