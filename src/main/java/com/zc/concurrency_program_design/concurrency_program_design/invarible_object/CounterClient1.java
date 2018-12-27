package com.zc.concurrency_program_design.concurrency_program_design.invarible_object;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Grubby
 * @date 2018/12/24
 */
public class CounterClient1 {


    public static void main(String[] args) {

        IntegerAcumulator integerAcumulator = new IntegerAcumulator();

        IntStream.range(0,3).forEach(item -> {
            new Thread(() -> {
                int inc = 0;
                while (true){
                    int oldValue = 0 ;
                    int result = 0;
                    synchronized (IntegerAcumulator.class){
                        oldValue = integerAcumulator.getValue();
                        result = integerAcumulator.add(inc);
                    }
                    System.out.println(oldValue + " + " + inc + " = " + result);
                    if (inc + oldValue != result){
                        System.out.println("ERROR" + oldValue + " + " + inc + " = " + result);
                    }
                    inc ++ ;
                    slowly();
                }
            }).start();
        });
    }

    private static void slowly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
