package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.net.Socket;

/**
 * @author Grubby
 * @date 2018/12/19
 */
@Slf4j
public class ClientHandler implements Runnable{

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream =  socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter writer = new PrintWriter(outputStream)){

            while (running){
               String message = br.readLine();
               if (message == null){
                   break;
               }
               System.out.println("come from client :" + message);
               writer.write(" ehco " + message);
               writer.flush();
            }
        } catch (IOException e) {
            this.running = true;
        }finally {
            this.close();
        }
    }

    public void close(){
        // 线程已经关闭
       if (running){
           return;
       }
       this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            log.info("close socket is fail");
        }
    }
}
