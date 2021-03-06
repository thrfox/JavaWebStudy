package com.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * ### IO的分类
 * IO主要分为两个部分
 * - 流式部分
 * -- IO的输入输出流，如InputStream,OutputStream,Reader,Writer，其中又分为Media Stream(介质流)和Filter Stream(装饰流/过滤流)
 * --- Media Stream: 指通过何种介质传输的流，如File、Byte[]、Char[]等
 * --- Filter Stream： 指对该介质的包装类进行处理的，如FilterInputStream/FilterOutputStream和FilterReader/FilterWriter的子类
 * - 非流式部分
 * -- 如File类、RandomAccessFile类
 * #### IO与NIO(JDK8)
 * 系统瓶颈在于IO
 * 阻塞型IO：
 *  - 打开IO通道
 *  - 通道中read和writer的速率不对应，造成read的等待(上传1M，下载10M，下载端等待)
 *  -- 异步或多线程
 * 非阻塞型：NIO
 *  Observer模式，观察者监控IO端口，有数据则调用程序read，无数据则断开。
 *
 * ### 字节流InputStream/OutputStream(抽象类)，字符流Reader/Writer(抽象类)
 * - 读写的单位不同： 字节流读写的单位为一个字节(8bit)；字符流为一个字符，一个字符可以包含多个字节
 * - 处理的对象不同： 字节流可以处理所有类型的数据，字符流只能处理字符数据
 *
 *
 *
 */
public class io {
    public void fileStreamTest() throws FileNotFoundException {
        FileInputStream file = new FileInputStream(new File(""));
        FileReader reader = new FileReader(new File(""));
    }
}
