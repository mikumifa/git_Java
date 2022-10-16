package com.test.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Sever {
    public static void main(String[] args) throws IOException {
        //端口开启和接受
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket acceptSocket = serverSocket.accept();
        System.out.println("waiting");
        //打开源文件
        String srcPath="C:\\Users\\mikumifa\\Downloads\\coa22-programming01.pdf";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
        //读取源文件的内容写到网络编程里面
        OutputStream outputStream = acceptSocket.getOutputStream();
        int len=0;
        byte[] buf = new byte[1024];
        while ((len= bufferedInputStream.read(buf))!=-1){
            outputStream.write(buf,0,len);
        }
        acceptSocket.shutdownOutput();
        //接受到回复的消息
        InputStream inputStream = acceptSocket.getInputStream();
        while ((len= inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        outputStream.close();
        acceptSocket.close();
        inputStream.close();
        bufferedInputStream.close();
    }
}
