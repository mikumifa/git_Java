package com.test.java;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Host {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        InputStream inputStream = socket.getInputStream();
        String descPath="c:\\Users\\mikumifa\\OneDrive\\桌面\\coa22-programming01.pdf";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(descPath));
        byte[] buf=new byte[1024];
        int len=0;
        while ((len=inputStream.read(buf))!=-1){
            bufferedOutputStream.write(buf,0,len);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("I accept the message!".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        inputStream.close();
        bufferedOutputStream.close();
    }
}
