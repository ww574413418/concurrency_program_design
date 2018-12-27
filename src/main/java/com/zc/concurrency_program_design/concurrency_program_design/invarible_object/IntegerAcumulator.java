package com.zc.concurrency_program_design.concurrency_program_design.invarible_object;

import java.util.TreeMap;

/**
 * 线程不安去的累加器
 * @author Grubby
 * @date 2018/12/24
 */
public class IntegerAcumulator {

    private int init;

    private final static int DEAFULT_VALUE = 0;

    public IntegerAcumulator() {
        this(DEAFULT_VALUE);
    }

    public IntegerAcumulator(int init) {
        this.init = init;
    }

    public int add(int i){
        this.init += i;
        return init;
    }

    public int getValue(){
        return this.init;
    }
}
