package org.javaboy.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Nio:通过多路复用的方式，一个线程可以处理多个连接。先不用考虑效率的问题。
 * 这个列子没有采用轮训的方法，遍历所有的连接，看这个连接上是否有数据过来，
 * 而是借助多路复用器，每次处理有事件的连接
 *
 * 这个IO模型：是IO多路复用模型；
 * Nio多路复用：是一个非阻塞同步IO；同步说的是，应用程序依然需要主动从内核将数据拷贝到用户工作空间
 *
 * 阻塞/非阻塞io 同步/非同步io 概念:https://blog.csdn.net/qq_35240226/article/details/82874174
    阻塞或者非阻塞是指应用程序在发起IO操作时，是立即返回还是等待
    同步或异步是指应用程序与内核通信时。数据从内核空间到应用空间的拷贝，是由内核主动发起，还是应用程序来来发出

  AIO：是异步io。

 */
public class ServerStep2 {

    public static void openServer(int port) {

        try {

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            // 多路复用器
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                //阻塞 直到有一个channel有事件就绪
                /**
                 * 事件就绪的意思是：如果有读请求，表示数据已经从网卡拷贝到了内核态。
                 *
                 *
                 */
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.attachment();
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.attachment();
                        // handRead
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // 这一步是将内核数据拷贝到用户空间，这个过程依然是一个阻塞的
                        socketChannel.read(buffer);

//                        socketChannel.write( buffer)
                    }
                    iterator.remove();
                }
            }

        } catch (Exception e) {

        }
    }
}
