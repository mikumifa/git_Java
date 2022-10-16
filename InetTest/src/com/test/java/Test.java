package com.test.java;

import javax.sound.midi.Soundbank;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost=InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress host1=InetAddress.getByName("DESKTOP-9ARHU10");
        System.out.println(host1);
        System.out.println(host1.getHostName());
        System.out.println(host1.getAddress());
        System.out.println(host1.getHostAddress());
        InetAddress host2=InetAddress.getByName("www.baidu.com");
        System.out.println(host2.getHostAddress());//IP地址
        System.out.println(host2.getHostName());//主机名字或者域名

    }
}
