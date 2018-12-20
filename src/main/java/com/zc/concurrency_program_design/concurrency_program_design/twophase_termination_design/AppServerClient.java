package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;

/**
 * @author Grubby
 * @date 2018/12/19
 */
public class AppServerClient {

    public static void main(String[] args) {
        AppServer appServer = new AppServer(13345);
        appServer.start();
    }
}
