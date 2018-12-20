package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author Grubby
 * @date 2018/12/19
 */
@Slf4j
public class AppServer extends Thread{
    /**
     * socket 的端口
     */
    private final int port;
    /**
     * 默认端口号
     */
    private final static int DEFAULT_PORT = 12345;
    /**
     * 让线程不断的接受 发来的信息
     */
    private volatile boolean start = true;
    /**
     * 记录工作线程
     */
    private List<ClientHandler> workThreads = new ArrayList<>();
    /**
     * 定义一个线程池
     */
    private final static ExecutorService EXECUTOR_SERVICE = newFixedThreadPool(10);

    private ServerSocket socket;

    public AppServer() {
        this(DEFAULT_PORT);
    }


    public AppServer(int port) {
        this.port = port;
    }


    @Override
    public void run() {
        try {
            socket = new ServerSocket(port);
            while (start) {
                // 获取一个客服端 然后交个一个工作线程去执行
                Socket client = socket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                // 启动一个线程 将socket 交给该线程去执行任务
                EXECUTOR_SERVICE.submit(clientHandler);
                //记录该线程
                workThreads.add(clientHandler);
            }
        } catch (IOException e) {
            log.error("The connect has been interrupt");

        }finally {
            // 关闭socket的时候 关闭对应的工作线程
            this.dispose();
        }
    }

    /**
     * socket 关闭之后要处理的 对应的工作线程
     */
    private void dispose() {
        //关闭对应的工作线程任务,调用它的stop方法
        workThreads.stream().forEach(ClientHandler::stop);
        //关闭线程池
        EXECUTOR_SERVICE.shutdown();
    }


    /**
     * 关闭socket
     */
    public void close(){
        try {
            this.start = false;
            // 关闭 socket 服务端
            this.socket.close();
            this.interrupt();
        } catch (IOException e) {
            log.error("close the socketServer is fail : {}" + e);
        }
    }
}
