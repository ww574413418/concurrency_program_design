package com.zc.concurrency_program_design.concurrency_program_design.invarible_object;

/**
 * 线程安全的 不可变对象 的累加器
 * @author Grubby
 * @date 2018/12/24
 */
public final  class IntegarAcumulator2 {

    private final int init;

    private final static int DEFAULT_VALUE = 0;

    public IntegarAcumulator2() {
        this(DEFAULT_VALUE);
    }

    public IntegarAcumulator2(int init) {
        this.init = init;
    }

    public IntegarAcumulator2(IntegarAcumulator2 integerAcumulator,int inc){
        this.init = integerAcumulator.getValue() + inc;
    }

    public IntegarAcumulator2 add(int init){
        IntegarAcumulator2 integarAcumulator2 = new IntegarAcumulator2(this,init);
        return integarAcumulator2;
    }


    public int getValue() {
        return init;
    }
}
