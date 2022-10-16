package com.test;

import java.util.LinkedList;

public class TransformerTest{
    public static void main(String[] args) {
    }
}
class Transformer {
    public String intToBinary(String numStr){
        int num=Integer.valueOf(numStr).intValue();
        StringBuilder ansBuilder=new StringBuilder();
        if(num==0)
            return "00000000000000000000000000000000";
        else if(num>0)
        {
            for(int i=0;i<31;i++)
            {
                ansBuilder.append(num%2);
                num=num>>1;
            }
            ansBuilder.append(0);
            ansBuilder.reverse();
            return ansBuilder.toString();
        }
        else {
            if(num==Integer.MIN_VALUE)
            {
                return "10000000000000000000000000000000";
            }
            else {
                num=num+Integer.MAX_VALUE+1;
                for(int i=0;i<31;i++)
                {
                    ansBuilder.append(num%2);
                    num=num>>1;
                }
                ansBuilder.append(1);
                ansBuilder.reverse();
                return ansBuilder.toString();
            }
        }
    }
    public String binaryToInt(String binStr){
    int index=1;
    int ans;
    ans=(binStr.charAt(0)-'0')*Integer.MIN_VALUE;
    while (index!=binStr.length()) {
        ans+=(binStr.charAt(index)-'0')*Math.pow(2,binStr.length()-index-1);
        index++;
    }
    return Integer.valueOf(ans).toString();
    }
    public String decimalToNBCD(String decimal){
        int index=0;
        StringBuilder ansBuilder=new StringBuilder();
        while (index!=decimal.length())
        {
            switch (decimal.charAt(index)){
                case '0'->{
                    ansBuilder.append("0000");
                    break;
                }
                case '1'->{
                    ansBuilder.append("0001");
                    break;
                }
                case '2'->{
                    ansBuilder.append("0010");
                    break;
                }
                case '3'->{
                    ansBuilder.append("0011");
                    break;
                }
                case '4'->{
                    ansBuilder.append("0100");
                    break;
                }
                case '5'->{
                    ansBuilder.append("0101");
                    break;
                }
                case '6'->{
                    ansBuilder.append("0110");
                    break;
                }
                case '7'->{
                    ansBuilder.append("0111");
                    break;
                }
                case '8'->{
                    ansBuilder.append("1000");
                    break;
                }
                case '9'->{
                    ansBuilder.append("1001");
                    break;
                }
            }
            index++;
        }
        return ansBuilder.toString();
    }
    public String NBCDToDecimal(String NBCDStr){
        int index=0;
        StringBuilder ansBuilder=new StringBuilder();
        while (index!=NBCDStr.length())
        {
            int tempAns=0;
            for(int i=0;i<4;i++){
                tempAns=tempAns*2+NBCDStr.charAt(index+i)-'0';
            }
            index+=4;
            ansBuilder.append(tempAns);
        }
        return ansBuilder.toString();
    }
    public String floatToBinary(String floatStr){
        float num=Float.valueOf(floatStr).floatValue();
        int bias=(int) Math.pow(2,7)-1;
        int sign=0;
        if(floatStr.charAt(0)=='-')
        {
            floatStr=new StringBuilder(floatStr).substring(1);
            sign=1;
            num=-num;
        }
        int dotPos=0;
        for(var c:floatStr.toCharArray()){
            if(c=='.')
                break;
            dotPos++;
        }
        //整数变成二进制
        int IntPart=Integer.parseInt(floatStr.substring(0,dotPos));
        float smallPart=num-(float) IntPart;
        StringBuilder intPartBuilder=new StringBuilder();
        final int intPart=IntPart;
        while (IntPart!=0){
            intPartBuilder.append(IntPart%2);
            IntPart/=2;
        }
        intPartBuilder.reverse();
        //小数部分

        StringBuilder smallPartBuilder=new StringBuilder();
        while (smallPart!=0){
            smallPartBuilder.append((int)(smallPart*2));
            smallPart=smallPart*2-(int)(smallPart*2);
        }
        int index=0;
        IntPart=intPart;
        if(IntPart==0) {
            for(;index<smallPartBuilder.length();index++){
                if(smallPartBuilder.charAt(index)=='1')
                    break;
            }
            index=-index-1;
        }
        else {
            index=intPartBuilder.length()-1;
        }
        //不考虑非规格化试一试
        //index变阶码
        StringBuilder EBuilder=new StringBuilder();
        index+=bias;
        for(int i=0;i<8;i++){
            EBuilder.append(index%2);
            index/=2;
        }
        EBuilder.reverse();
        //尾码
        StringBuilder MBuilder=new StringBuilder();
        intPartBuilder.append(smallPartBuilder.toString());
        for(int i=0;i<23;i++){
            if(i+1<intPartBuilder.length())
                MBuilder.append(intPartBuilder.charAt(i+1));
            else
                MBuilder.append('0');
        }
        StringBuilder ansBuilder=new StringBuilder();
        ansBuilder.append(sign);
        ansBuilder.append(EBuilder.toString());
        ansBuilder.append(MBuilder.toString());
        return ansBuilder.toString();
    }
    public String binaryToFloat(String binStr){
        int bias=(int) Math.pow(2,7)-1;
        int EValue=0;
        float MValue=0;
        int sign=1;
        if(binStr.charAt(0)=='1')
            sign=-1;
        String E= binStr.substring(1,9);
        String M= binStr.substring(9,32);
        if(E.equals("11111111")&&M.equals("00000000000000000000000")){
            if(sign==1)
                return "+inf";
            else return "-inf";
        }
        else if(E.equals("00000000")) {
            if(M.equals("00000000000000000000000"))
                return "0";
            else {
                EValue=1-bias;
                for(int i=22;i>=0;i--){
                    MValue=MValue/(float) 2+(float)(M.charAt(i)-'0');
                }
                MValue/=(float) 2;
            }
        }
        else {
            for(int i=0;i<8;i++){
                EValue=EValue*2+E.charAt(i)-'0';
            }
            EValue=EValue-bias;
            for(int i=22;i>=0;i--){
                MValue=MValue/(float) 2+(float)(M.charAt(i)-'0');
            }
            MValue/=(float) 2;
            MValue+=(float) 1;
        }
        return Float.valueOf(sign*MValue*(float)Math.pow(2,EValue)).toString();
    }

}
