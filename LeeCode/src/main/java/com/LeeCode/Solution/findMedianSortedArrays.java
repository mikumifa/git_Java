package com.LeeCode.Solution;

import org.junit.Test;
public class findMedianSortedArrays {
    @Test
    public void test(){
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        * */
        int index1=0,index2=0;int count=0;int len=nums1.length+nums2.length;
        int pre=0,now=0;
        for(int i=0;i<len/2+1;i++){
            pre=now;//一开始pre的值一开始是now，相当于now、记录了一下
//            if(index1==nums1.length);
//            {
//                now = nums2[index2];
//                index2++;
//            }
//            else if(index2== nums2.length);
//            {
//                now = nums1[index1];
//                index1++;
//            }
//            else {
//                now=Math.min(nums1[index1],nums2[index2]);
//                if(nums1[index1]<nums2[index2])
//                {
//                    now=nums1[index1];
//                    index1++;
//                }
//                else if(nums1[index1]==nums2[index2]){
//
//                }
//            }
//用简单的条件判断消除复杂的if-else if-else
            if(index2>= nums2.length||(index1< nums1.length)&&nums1[index1]<nums2[index2])//在now取谁上用布尔运算减少计算
                now=nums1[index1++];
            else now=nums2[index2++];//这种方式减少代码量
        }
        if(len%2==1)
            return (double) now;
        else
            return  (double) (now+pre)/2.0;
    }
}
