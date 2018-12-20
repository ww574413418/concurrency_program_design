package com.zc.concurrency_program_design.concurrency_program_design.dining_philosophers_problem;

/**
 * 就餐线程
 * @author Grubby
 * @date 2018/12/20
 */
public class EatDinnerThread2 extends Thread{

    private final String name;

    private final TableWarePair pair;

    public EatDinnerThread2(String name, TableWarePair pair) {
        this.name = name;
        this.pair = pair;
    }


    @Override
    public void run() {
        while (true){
            this.eat();
        }
    }

    /**
     * 吃东西
     */
    private void eat() {
        synchronized (pair){

            System.out.println("take the pairTool");
            System.out.println("================");
            System.out.println("starting working");
            System.out.println("================");
            System.out.println("put down pairTool");

        }
    }

}
