package com.zc.concurrency_program_design.concurrency_program_design.dining_philosophers_problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Grubby
 * @date 2018/12/20
 */
public class EatDinnerClient {

    public static void main(String[] args) {

        TableWare leftTableWare = new TableWare("left");
        TableWare rightTableWare = new TableWare("right");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1,5).forEach(i -> new EatDinnerThread("Tom" + i,leftTableWare,rightTableWare).start());
    }
}
