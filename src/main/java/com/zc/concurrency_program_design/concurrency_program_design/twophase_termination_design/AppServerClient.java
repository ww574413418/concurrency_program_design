package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author Grubby
 * @date 2018/12/19
 */
@Slf4j
public class AppServerClient {

    public static void main(String[] args) {
        try {
            AppServer appServer = new AppServer();
            appServer.start();

            TimeUnit.SECONDS.sleep(5);

            appServer.close();
        } catch (InterruptedException e) {
            log.error("server throw Exception : {}",e);
        }
    }
}
