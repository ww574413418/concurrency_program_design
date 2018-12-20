package com.zc.concurrency_program_design.concurrency_program_design.dining_philosophers_problem;

/**
 * 就餐线程
 * @author Grubby
 * @date 2018/12/20
 */
public class EatDinnerThread extends Thread{

    private final String name;

    private final TableWare leftTableWare;

    private final TableWare rightTableWare;

    public EatDinnerThread(String name, TableWare leftTableWare, TableWare rightTableWare) {
        this.name = name;
        this.leftTableWare = leftTableWare;
        this.rightTableWare = rightTableWare;
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
        synchronized (leftTableWare){
            System.out.println("take the leftTool");
            synchronized (rightTableWare){
                System.out.println("take the rightTool");
                System.out.println("================");
                System.out.println("starting working");
                System.out.println("================");
                System.out.println("put down rightTool");
            }
            System.out.println("put down leftTool");
        }
    }

}
