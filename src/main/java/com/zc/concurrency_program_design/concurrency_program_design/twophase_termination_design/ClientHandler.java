package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.Socket;

/**
 * 工作线程
 * @author Grubby
 * @date 2018/12/19
 */
@Slf4j
public class ClientHandler implements Runnable{

    private final Socket socket;

    /**
     * 判断该任务线程是否关闭
     */
    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream =  socket.getOutputStream();
             // 读客服端数据
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             // 将数据写给 客户端
             PrintWriter writer = new PrintWriter(outputStream);){
            while (running){
                String message = reader.readLine();
                // 消息为null 说明手动关闭了 terminal
                if (message == null){
                    break;
                }
                System.out.println("come from client message :" +message);
                writer.write("hello :" + message + "\n");
                writer.flush();
            }
        }catch (IOException e){
            log.error("connect the server is fail");
        }finally {
            // 关闭自己
            this.running = false;
            this.stop();
        }
    }

    /**
     * 关闭该线程任务
     */
    public void stop(){
        try {
            // 在我们手动关闭之前就已经 死亡了
            if (!running){
                return;
            }
            this.running = false;
            //关闭socket 客户端
            this.socket.close();
        } catch (IOException e) {
            log.error("closing the socket is fail and Exception : {}",e);
        }
    }
}
