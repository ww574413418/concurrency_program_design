/**
 * Future 设计模式 异步的处理任务
 * 主线程 开启子线程执行任务  主线程继续往下执行自己的任务
 * 当子线程任务完成后,在将任务返回给主线程
 * 这样主线程不用等待子线程的执行结果,可以先做自己的事情,在需要的时候在获取子线程的执行结果
 *
 * 任务接口{@link com.zc.concurrency_program_design.concurrency_program_design.future_design.Task}
 * 获取任务结果接口{@link com.zc.concurrency_program_design.concurrency_program_design.future_design.Future}
 * 获取任务结果实现类 {@link com.zc.concurrency_program_design.concurrency_program_design.future_design.FutureResult}
 * 子线程,开启一个线程执行任务{@link com.zc.concurrency_program_design.concurrency_program_design.future_design.FutureService}
 * 主线程,main方法 {@link com.zc.concurrency_program_design.concurrency_program_design.future_design.FutureClient}
 */
package com.zc.concurrency_program_design.concurrency_program_design.future_design;