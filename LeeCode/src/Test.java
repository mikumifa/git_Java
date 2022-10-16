import java.util.Arrays;
import
public class Test {
    @Test
    public void multiplyTest1(){

    }
}
class Solution {
    public String multiply(String num1, String num2) {
        char[] num1CharArray=num1.toCharArray();
        char[] num2CharArray=num2.toCharArray();
        int[] ansIntArray=new int[num1.length()+num2.length()];
        Arrays.setAll(ansIntArray, x->0);
        for(int yIndex=0;yIndex<num2.length();yIndex++)
        {   for(int xIndex=0;xIndex<num1.length();xIndex++){
            ansIntArray[yIndex+xIndex]+=(int)(num1CharArray[xIndex]-'0')*(int)(num2CharArray[yIndex]-'0');
        }
        }
        StringBuffer ansBuffer=new StringBuffer();
        for(int i=ansIntArray.length-1;i>0;i--){
            ansIntArray[i-1]+=ansIntArray[i]/10;
            ansIntArray[i]=ansIntArray[i]%10;
            ansBuffer.append(ansIntArray[i]);
        }
        ansBuffer.append(ansIntArray[0]%10);
        ansBuffer.append(ansIntArray[0]/10);
        return ansBuffer.reverse().toString();
    }
}