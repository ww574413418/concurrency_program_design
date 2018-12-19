package com.zc.concurrency_program_design.concurrency_program_design.thread_pre_message_design;

import java.util.stream.IntStream;

/**
 * @author Grubby
 * @date 2018/12/19
 */
public class PreThreadClient {
    public static void main(String[] args) {

        MessageHandler messageHandler = new MessageHandler();

        IntStream.rangeClosed(1,10).forEach(i -> messageHandler.request(new Message("hello")));

        messageHandler.shutdown();
    }
}
