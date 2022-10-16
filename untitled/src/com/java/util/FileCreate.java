package com.java.util;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public void create01(){
        String filePath="C:\\Users\\mikumifa\\Downloads\\news1.txt";//根据路径构建一个File对象
        File file=new File(filePath);
        try {
            file.createNewFile();
            System.out.println("Create successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void create02(){
        String fatherFilePath="C:\\Users\\mikumifa\\Downloads";//根据父文件加上子目录
        String childFilePath="new2.txt";
        File file=new File(fatherFilePath);
        try {
            File file2=new File(file,childFilePath);
            file2.createNewFile();
            System.out.println("Create successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void create03(){
        String fatherFilePath="C:\\Users\\mikumifa\\Downloads";//根据父文件加上子目录
        String childFilePath="new3.txt";
        File file=new File(fatherFilePath,childFilePath);
        try {
            file.createNewFile();
            System.out.println("Create successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void  create04(){
        String inputAddress="c:\\Users\\mikumifa\\Downloads\\coa22-programming01.pdf";
        String outputAddress="c:\\Users\\mikumifa\\OneDrive\\桌面\\coa22-programming01.pdf";
        FileInputStream fileInputStream =null;
        FileOutputStream fileOutputStream =null;
        try {
            fileInputStream = new FileInputStream(inputAddress);
            fileOutputStream = new FileOutputStream(outputAddress);
            int val=0;
            byte[] valByte=new byte[1024];
//            while (true){
//                try {
//                    if (((val=fileInputStream.read())==-1)) break;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    fileOutputStream.write(val);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            while ((val=fileInputStream.read(valByte))!=-1)
            {
                fileOutputStream.write(valByte,0,val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
