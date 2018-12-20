package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/19
 */
public class CounterTest {

    public static void main(String[] args) throws InterruptedException {

        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        TimeUnit.MILLISECONDS.sleep(1000);

        counterIncrement.close();

    }
}
