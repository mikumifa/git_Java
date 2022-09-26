package com.test.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;

import static java.lang.Character.isLetter;
import static java.lang.Math.max;

public class sort {
    public static void main(String[] args) {

//            System.out.println(numberOfBinary(13));
//            permute("abc");
//            int[] t=new int[]{1,8,1,61,65,12,3,5};
//            System.out.println(findMax(t,t.length));
//            System.out.println(getAverageNum(t,t.length));
//            String s="Madam, I’m \n Adam";
//            System.out.println(isCirWord(s,0,s.length()-1));
//            System.out.println(isCirSen(s,0,s.length()-1));
//            System.out.println(s);
//            getRfromN(5,3);
//            hanoi(3);

    }
    public static int numberOfBinary(int n){
        if(n==0)
            return 0;
        if(n%2!=0)
            return  numberOfBinary(n/2)+1;
        else return numberOfBinary(n/2);
    }
    public static void permute(String str){
        permute(str.toCharArray(),0,str.length()-1);//string变char数组
    }
    public static void swap(char[] str,int a,int b){
        var t=str[a];
        str[a]=str[b];
        str[b]=t;
    }

    public static void permute(char [ ] str, int low, int high){

        if(low==high)
            System.out.println(String.valueOf(str)+" ");
        else {
            for(int i=low;i<=high;i++)
            {
                swap(str,low,i);
                permute(str,low+1,high);
                swap(str,low,i);
            }
        }
    }

    public static int findMax(int[] a,int n){//a的n项的最大值
        if(n==1)
            return a[0];
        else {
            return max(a[n-1],findMax(a,n-1));
        }
    }
    public static double getAverageNum(int[] a,int n){
        if(n==1)
            return (double)a[0];
        else return (getAverageNum(a,n-1)*(n-1)+a[n-1])/(double)n;
    }
    public static int getListLen(Node head){
        if(head.next==null)
            return 1;
        else {
            return 1+getListLen(head.next);
        }

    }
    public static boolean isCirWord(String str,int begin,int end){
        if(begin>=end)
            return true;
        else {
            return isCirWord(str,begin+1,end-1)&&(str.charAt(begin)==str.charAt(end));
        }
    }
    public static boolean isCirSen(String str,int begin,int end){
        str=str.toLowerCase();
        while (isLetter(str.charAt(end))==false)
        {
            end--;
        }
        while (isLetter(str.charAt(begin))==false)
        {
            begin++;
        }
        if(begin>=end)
            return true;
        else {
            return isCirSen(str,begin+1,end-1)&&(str.charAt(begin)==str.charAt(end));
        }
    }
    public static void getRfromN(int n,int r){
        boolean[] used=new boolean[n+1];
        Arrays.fill(used,false);
        LinkedList<Integer> path=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            used[i]=true;
            path.add(i);
            getRfromNFun(n,r-1,path,used);
            path.removeLast();
            used[i]=false;
        }
    }
    public  static void getRfromNFun(int n,int r,LinkedList<Integer>path,boolean[] used){
        if(r==0)
        {
            System.out.println(path.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]==false){
                used[i]=true;
                path.add(i);
                getRfromNFun(n,r-1,path,used);
                path.removeLast();
                used[i]=false;
            }
        }
    }
    public static void hanoi(int n){
        xToyHanoi(n,0,2);
    }
    public static void xToyHanoi(int n,int x,int y){
        if(n==1)
        {
            System.out.println("move "+x+" to "+y);
            return;
        }
        else{
            int t;
            for(t=0;t<=2&&(t==x||t==y);t++);
            xToyHanoi(n-1,x,t);
            xToyHanoi(1,x,y);
            xToyHanoi(n-1,t,y);
        }
    }
}
class Node{
    public int  value;
    public Node next;
    Node(){
        value=0;
        next=null;
    }
}