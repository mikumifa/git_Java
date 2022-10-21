package com.LeeCode.Solution;

import org.junit.Test;

import java.util.Arrays;

public class searchRange {
    @Test
    public void test(){
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,9},8)));
    }
    public int[] searchRange(int[] nums, int target) {
        int len= nums.length;
        int begin=0;int end=len-1;
        int mid=(begin+end)/2;
        while (begin<=end) {
            mid=(begin+end)/2;
            if (nums[mid] == target) {
                int a, b;
                a = b = mid;
                while (a - 1 >= 0 && nums[a - 1] == target)
                    a--;
                while (b + 1 < len && nums[b + 1] == target)
                    b++;
                return new int[]{a, b};
            } else if (nums[mid] < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
