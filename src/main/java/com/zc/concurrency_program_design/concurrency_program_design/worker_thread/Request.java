package com.zc.concurrency_program_design.concurrency_program_design.worker_thread;

import com.fasterxml.jackson.core.sym.NameN;

/**
 * 商品
 * @author Grubby
 * @date
 */
public class Request {
    private final String name;

    private final int number;

    public Request(final String name,final  int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executed " + this);
    }

    @Override
    public String toString() {
        return "Request -> No." + number + " Name: " + name;
    }
}
