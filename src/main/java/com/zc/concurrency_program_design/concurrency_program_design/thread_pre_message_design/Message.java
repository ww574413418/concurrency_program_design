package com.zc.concurrency_program_design.concurrency_program_design.thread_pre_message_design;

/**
 * @author Grubby
 * @date 2018/12/19
 */
public class Message {

    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
