package com.LeeCode.Solution;

import java.nio.Buffer;
import java.util.Arrays;

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
}
