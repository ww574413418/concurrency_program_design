package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

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
public class AppServer extends Thread{
    private final int port;

    private final static int DEFAULT_PORT = 123123;

    private volatile boolean start  = true;

    /**
     * 存贮工作线程
     */
    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private final static ExecutorService EXECUTOR  = newFixedThreadPool(10);

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket socket = new ServerSocket(port);
            while (start){
                Socket client = socket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                clientHandlers.add(clientHandler);
                EXECUTOR.submit(clientHandler);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            this.dispose();
        }
    }

    /**
     * 关闭资源
     */
    private void dispose() {
        clientHandlers.stream().forEach(item -> item.close());
        EXECUTOR.shutdown();
    }

    public void shutDown(){
        this.start = false;
    }


}
